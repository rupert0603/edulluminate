import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location, CommonModule } from '@angular/common';
import { SchoolService } from '../services/api/school/school.service';
import { Review, School, SchoolSummary } from '../../types';
import { ReviewComponent } from '../review/review.component';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';

import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule} from '@angular/forms';
import { WriteReviewComponent } from '../write-review/write-review.component';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-school-review',
  standalone: true,
  imports: [ReviewComponent, CommonModule, MatCardModule, MatButtonModule,
    // FormsModule, MatFormFieldModule, MatInputModule
    WriteReviewComponent
  ],
  templateUrl: './school-review.component.html',
  styleUrl: './school-review.component.scss'
})
export class SchoolReviewComponent implements OnInit {
  reviews: Array<Review> = [];
  school: School = {
    id: -1,
    country: '',
    municipality: '',
    name: '',
    taxonomy: ''
  };

  doWriteReview = false;

  toggleWriteReview() {
    this.doWriteReview = !this.doWriteReview;
  }

  constructor(
    private route: ActivatedRoute,
    // private location: Location,
    private schoolService: SchoolService,
    protected readonly keycloak: KeycloakService
  ) {}

  ngOnInit(): void {
    this.getReviews();
    this.getSchool();
  }

  getReviews() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.schoolService.getReviews(id)
      .subscribe(reviews => this.reviews = reviews);
  }

  getSchool() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.schoolService.getSchool(id)
      .subscribe(school => this.school = school);
  }

  addNewReview(review: Review) {
    this.reviews.unshift(review);
    this.doWriteReview = false;
  }
}

// https://stackoverflow.com/questions/72212838/angular-11-switchmap-not-working-after-catch-error