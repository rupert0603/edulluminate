import { Component, Input } from '@angular/core';
import { Question } from '../../../types';

@Component({
  selector: 'app-question',
  standalone: true,
  imports: [],
  templateUrl: './question.component.html',
  styleUrl: './question.component.scss'
})
export class QuestionComponent {

  @Input() question!: Question;

  
}
