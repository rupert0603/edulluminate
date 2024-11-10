import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SchoolReviewComponent } from './school-review/school-review.component';
import { BookDisplayComponent } from './books/book-display/book-display.component';
import { ChapterComponent } from './books/chapter/chapter.component';
import { MenuComponent } from './books/menu/menu.component';
import { QuestionComponent } from './books/question/question.component';
import { authGuard } from './services/keycloak/auth.guard.';

export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    // canActivate: [authGuard]
  },
  {
    path: 'books',
    component: BookDisplayComponent
  },
  {
    path: 'school/:id',
    component: SchoolReviewComponent
  },
  {
    path: 'books/:bookId/chapter/:chapterId',
    // component: ChapterComponent
    // component: MenuComponent,
    // redirectTo: 'books/:bookId/chapter/:chapterId/chapter-companion',
    children: [
      {
        path: 'chapter-companion',
        // component: ChapterComponent
        component: MenuComponent
      },
      {
        path: 'questions',
        // component: QuestionComponent
        component: MenuComponent
      },
      { path: '', redirectTo: 'chapter-companion', pathMatch: 'full' }


      // {
      //   path: 'questions',
      //   component: QuestionsComponent
      // },
      // {
      //   path: 'questions/:questionId',
      //   component: QuestionComponent
      // }
      // https://stackoverflow.com/questions/74531261/angular-how-to-use-nested-child-routing
      // https://timdeschryver.dev/blog/til-paramsinheritancestrategy-to-always-have-access-to-parent-route-info
    ]
  }
];
