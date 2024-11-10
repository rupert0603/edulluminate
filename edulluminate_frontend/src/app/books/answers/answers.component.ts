import { Component, Input, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { Answer } from '../../../types';
import { BookService } from '../../services/api/book/book.service';
import {MatCardModule} from '@angular/material/card';

@Component({
  selector: 'app-answers',
  standalone: true,
  imports: [MatCardModule],
  templateUrl: './answers.component.html',
  styleUrl: './answers.component.scss',
  // changeDetection: ChangeDetectionStrategy.OnPush,

})
export class AnswersComponent implements OnInit {
  @Input() questionId!: number;
  answers: Answer[] = [];

  constructor(private bookService: BookService){}

  ngOnInit(): void {
    this.getAnswers();
  }
  getAnswers(){
    this.bookService.getAnswers(this.questionId)
      .subscribe(answers => this.answers = answers);
  }
}
