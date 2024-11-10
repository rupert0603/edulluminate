import { Component, EventEmitter, inject, Input, Output } from '@angular/core';
import { FormBuilder, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';
import { SchoolService } from '../services/api/school/school.service';
import { Review, ReviewRequest } from '../../types';
import {MatButtonModule} from '@angular/material/button';
import { WriteReviewSnackbarComponent } from '../snackbar/write-review-snackbar/write-review-snackbar.component';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-write-review',
  standalone: true,
  imports: [FormsModule, MatFormFieldModule, MatInputModule, MatCardModule, ReactiveFormsModule,
    MatButtonModule
  ],
  templateUrl: './write-review.component.html',
  styleUrl: './write-review.component.scss'
})
export class WriteReviewComponent {

  ratings = [
    {
      name: "Academics",
      property: "academicsRating",
      value: null
    }, 
    {
      name: "Teachers",
      property: "teachersRating",
      value: null
    }, 
    {
      name: "Peer Quality",
      property: "peerQualityRating",
      value: null
    },
    {
      name: "Facilities",
      property: "facilitiesRating",
      value: null
    },
    {
      name: "Sports",
      property: "sportsRating",
      value: null
    },
    {
      name: "Clubs",
      property: "clubsRating",
      value: null
    },
    {
      name: "Student Life",
      property: "studentLifeRating",
      value: null
    },
    {
      name: "Location",
      property: "locationRating",
      value: null
    },
    {
      name: "Staff",
      property: "staffsRating",
      value: null
    },
    {
      name: "Food",
      property: "foodRating",
      value: null
    }
  ]

  @Input() schoolId!: number;
  @Output() successAddReviewEvent: EventEmitter<Review> = new EventEmitter();

  reviewForm = this.formBuilder.group({
    academicsRating: this.formBuilder.control<number | null>(null, [Validators.required]),
      teachersRating: this.formBuilder.control<number | null>(null, [Validators.required]),
      peerQualityRating: this.formBuilder.control<number | null>(null, [Validators.required]),
      facilitiesRating: this.formBuilder.control<number | null>(null, [Validators.required]),
      sportsRating: this.formBuilder.control<number | null>(null, [Validators.required]),
      clubsRating: this.formBuilder.control<number | null>(null, [Validators.required]),
      studentLifeRating: this.formBuilder.control<number | null>(null, [Validators.required]),
      locationRating: this.formBuilder.control<number | null>(null, [Validators.required]),
      staffsRating: this.formBuilder.control<number | null>(null, [Validators.required]),
      foodRating: this.formBuilder.control<number | null>(null, [Validators.required]),
      review: ['', Validators.required],
      // academicsRating: [null, Validators.required],
      // teachersRating: [null, Validators.required],
      // peerQualityRating: [null, Validators.required],
      // facilitiesRating: [null, Validators.required],
      // sportsRating: [null, Validators.required],
      // clubsRating: [null, Validators.required],
      // studentLifeRating: [null, Validators.required],
      // locationRating: [null, Validators.required],
      // staffsRating: [null, Validators.required],
      // foodRating: [null, Validators.required],
      // review: ['', Validators.required],
  });

  constructor(
    private formBuilder: FormBuilder,
    private schoolService: SchoolService
  ) {}
  
  onSubmit(): void {
    // console.log(this.reviewForm);
    // console.log(this.reviewForm.value);
    // https://stackoverflow.com/questions/55061066/how-to-validate-form-input-on-submit-in-angular-6
    // https://www.pluralsight.com/resources/blog/guides/using-formbuilder-in-angular
    // https://v17.angular.io/start/start-forms
    if(this.reviewForm.status === 'VALID') {
      // console.log(this.schoolId);
      const reviewRequest = {
        ...this.reviewForm.value,
        schoolId: this.schoolId
      };

      // this.f

      // this.schoolService.postReview(this.reviewForm.value);
      this.schoolService.postReview(reviewRequest as ReviewRequest)
        .subscribe((reviewId) => {
          // new this.successAddReview({});

          this.reviewForm.reset();

          this.successAddReviewEvent.emit({
            ...reviewRequest,
            id: reviewId
          } as Review);

          this.openSnackBar();
        });
      // this.validateReviewRequest(this.reviewForm.value)
    }
  }

  private _snackBar = inject(MatSnackBar);
  durationInSeconds = 5;
  openSnackBar() {
    this._snackBar.openFromComponent(WriteReviewSnackbarComponent, {
      duration: this.durationInSeconds * 1000,
    });
  }

  // https://stackoverflow.com/questions/73394435/angular-14-typed-forms-initial-value-for-number-controls

  // https://stackoverflow.com/questions/63045111/how-to-convert-or-cast-partialt-to-t
  // https://stackoverflow.com/questions/57086672/element-implicitly-has-an-any-type-because-expression-of-type-string-cant-b


  // f(_: ReviewForm) { }
  // private validateReviewRequest<T> (obj: Object){

  //   Object.keys(obj).forEach(key => {
  //     if(obj[key] !== undefined || object[key] !== null) {

  //     }
  //   });
  // }
}

type ReviewForm = {
  academicsRating: number,
  teachersRating: number,
  peerQualityRating: number,
  facilitiesRating: number,
  sportsRating: number,
  clubsRating: number,
  studentLifeRating: number,
  locationRating: number,
  staffsRating: number,
  foodRating: number,
  review: string
};