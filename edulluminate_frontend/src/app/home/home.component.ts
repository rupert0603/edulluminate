import { Component, EventEmitter, inject, OnInit } from '@angular/core';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import { debounceTime, distinctUntilChanged, Observable, Subject, switchMap, interval, catchError, of, throwError } from 'rxjs';
import { SchoolService } from '../services/api/school/school.service';
import { SchoolResultComponent } from '../school-result/school-result.component';
import { School } from '../../types';
import { CommonModule } from '@angular/common';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import {
  MatSnackBar
} from '@angular/material/snack-bar';
import { HomeSnackbarComponent } from '../snackbar/home-snackbar/home-snackbar.component';
import {MatButtonModule} from '@angular/material/button';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule, MatIconModule,
    SchoolResultComponent, CommonModule,
    ReactiveFormsModule, MatButtonModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})

export class HomeComponent implements OnInit {
  searchForm = this.formBuilder.group({
    searchText: ''
  });

  private _snackBar = inject(MatSnackBar);
  durationInSeconds = 5;
  openSnackBar() {
    this._snackBar.openFromComponent(HomeSnackbarComponent, {
      duration: this.durationInSeconds * 1000,
    });
  }

  // withRefresh = false;
  searchInputs$!: any;
  private searchText$ = new Subject<string>();
  schools: Array<School> = [];
  disableLoadMoreBtn = true;

  constructor(
    private schoolService: SchoolService,
    private formBuilder: FormBuilder
  ) {}

  getValue(event: Event): string {
    return (event.target as HTMLInputElement).value;
  }
  search(searchString: string) {
    this.searchText$.next(searchString);
  }

  onEnter($event: any){
    $event.preventDefault(); 
    $event.stopPropagation();
  }

  onSubmit($event: any){
    $event.preventDefault(); 
    $event.stopPropagation();
  }

  ngOnInit() {
    this.searchText$.pipe(
      debounceTime(500),
      distinctUntilChanged(),
      switchMap(searchInput => {
          return this.schoolService.getSchools(searchInput, 0)
        }
      ),
      catchError((err) => {
        console.log("Error received: ", err);
        this.openSnackBar();
        return throwError(() => new Error('Sorry, we couldn’t complete your request. Please try again later.'));
      })
      // https://paul-chesa.medium.com/handling-errors-from-http-calls-in-angular-4dbc7f6b26ca
      // https://blog.angular-university.io/rxjs-error-handling/
      // https://medium.com/@nandeepbarochiya/error-handling-operators-in-rxjs-a-comprehensive-guide-07cb7c75149f
    )
    .subscribe(
      (e) => { 
        // this.schools.push(...e); 
        this.schools = e;
        if(this.schools.length < 10){
          this.disableLoadMoreBtn = true;
        } else {
          this.disableLoadMoreBtn = false;
        }
      },
    );

    // this.searchText$.pipe(debounceTime(500)).subscribe((searchValue: any) => {
    //   // this.performSearch(searchValue);
    //   console.log("ahahha");
    // });
  }

  loadMoreSchools(){
    this.schoolService.getSchools(this.searchForm.value.searchText as string, this.schools[this.schools.length - 1].id)
    .subscribe(e => { 
      // this.questions = questions;
      this.schools.push(...e);
      if(e.length < 10){
        this.disableLoadMoreBtn = true;
      } else {
        this.disableLoadMoreBtn = false;
      }

    });
  }

}

// https://v17.angular.io/guide/http-interceptor-use-cases#cache-refresh
// https://v17.angular.io/guide/http-optimize-server-interaction
// https://dev.to/mana95/how-to-use-rxjs-debounce-time-with-angular-4aj5