import { Component, OnInit, ChangeDetectionStrategy, signal } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookService } from '../../services/api/book/book.service';
import { Question } from '../../../types';
import { QuestionComponent } from '../question/question.component';
import {MatExpansionModule} from '@angular/material/expansion';
import { AnswersComponent } from '../answers/answers.component';
import {MatButtonModule} from '@angular/material/button';

@Component({
  selector: 'app-questions',
  standalone: true,
  imports: [MatExpansionModule, QuestionComponent, AnswersComponent, MatButtonModule],
  templateUrl: './questions.component.html',
  styleUrl: './questions.component.scss',
  // changeDetection: ChangeDetectionStrategy.OnPush
})
export class QuestionsComponent implements OnInit {

  private page = 0;
  questions: Array<Question> = [];
  disableLoadMoreBtn = true;

  constructor(
    private route: ActivatedRoute,
    private bookService: BookService
  ){}

  ngOnInit(): void {
    this.getQuestions();
  }

  getQuestions() {
    const chapterId = Number(this.route.snapshot.paramMap.get('chapterId'));
    this.bookService.getQuestions(chapterId, this.page)
      .subscribe(questions => { 
        this.questions = questions;
        this.page++;
        if(this.questions.length < 10){
          this.disableLoadMoreBtn = true;
        } else {
          this.disableLoadMoreBtn = false;
        }
      });
  }

  loadMoreQuestions(){
    // console.log(this.disableLoadMoreBtn);
    const chapterId = Number(this.route.snapshot.paramMap.get('chapterId'));
    this.bookService.getQuestions(chapterId, this.page)
      .subscribe(questions => { 
        // this.questions = questions;
        this.questions.push(...questions);
        this.page++;
        if(questions.length < 10){
          this.disableLoadMoreBtn = true;
        } else {
          this.disableLoadMoreBtn = false;
        }

    });
  }
}
