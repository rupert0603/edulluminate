import { Component, Input } from '@angular/core';
import { Review } from '../../types';
import {MatCardModule} from '@angular/material/card';
// import {MatButtonModule} from '@angular/material/button';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatDividerModule} from '@angular/material/divider';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-review',
  standalone: true,
  imports: [MatCardModule, MatProgressSpinnerModule, MatGridListModule, MatDividerModule,
    CommonModule
  ],
  templateUrl: './review.component.html',
  styleUrl: './review.component.scss'
})
export class ReviewComponent {

  @Input() review!: Review;

  
}
