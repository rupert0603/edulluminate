import { Component, Input, OnInit } from '@angular/core';
import { BookService } from '../../services/api/book/book.service';
import { Answer } from '../../../types';

@Component({
  selector: 'app-answer',
  standalone: true,
  imports: [],
  templateUrl: './answer.component.html',
  styleUrl: './answer.component.scss'
})
export class AnswerComponent implements OnInit {
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
