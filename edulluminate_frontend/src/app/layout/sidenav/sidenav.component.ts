import { Component, DoCheck, Input, NgModule, OnInit } from '@angular/core';

import { ToolbarComponent } from '../toolbar/toolbar.component';
import { RouterModule, ActivatedRoute } from '@angular/router';
import { BookService } from '../../services/api/book/book.service';
import { Question } from '../../../types';
import { routes } from '../../app.routes';

@NgModule({
  imports: [RouterModule.forRoot(routes)]
})
class MyNgModule {}
@Component({
  selector: 'app-sidenav',
  standalone: true,
  imports: [ToolbarComponent],
  templateUrl: './sidenav.component.html',
  styleUrl: './sidenav.component.scss'
})
export class SidenavComponent implements OnInit {
//   doShowDrawer: boolean = false;
  page = 0;
  questions: Array<Question> =  [];

  @Input()
  set chapterId(chapterId: string) {
    // console.log(chapterId);
  }

  constructor(
    private route: ActivatedRoute,
    private bookService: BookService
  ) {}
  // ngDoCheck(): void {
  //   this.getQuestions();
  // }

  ngOnInit(): void {
    this.getQuestions();
  }

 

  getQuestions() {
    // console.log(this.route.snapshot.queryParams );
    // const bookId = Number(this.route.snapshot.paramMap.get('bookId'));
    // const chapterId = Number(this.route.snapshot.paramMap.get('chapterId'));
    // console.log(chapterId);
    // this.route.data.subscribe(data => console.log(data))

    // this.route.params.subscribe(params => {
    //   console.log(params['bookId']);
    // });
    // this.route.parent!.params
    // console.log(this.route.firstChild);
    // if(this.route.parent !== null) {
    //     this.route.parent.params.subscribe(params => {
    //       console.log(params['bookId']);
    //     });
    // }
    // this.route.parent.params.swichMap(params => {
    //   console.log(params);
    // });
    // this.bookService.getQuestions(chapterId, this.page)
    //   .subscribe(questions => this.questions = questions);
  }
}


// https://stackoverflow.com/questions/49632152/angular-2-how-to-access-active-route-outside-router-outlet
// https://stackoverflow.com/questions/42947133/parent-components-gets-empty-params-from-activatedroute
// https://stackoverflow.com/questions/55411353/angular-get-value-of-parameter-in-parent-route