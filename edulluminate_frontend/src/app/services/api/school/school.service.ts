import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SchoolSummary, Review, ReviewRequest, School } from '../../../../types';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SchoolService {
  private baseUrl = environment.schoolServiceBaseUrl;
  constructor(
    private http: HttpClient
  ) { }

  getSchools(searchInput: string, lastItemId: number) {
    const schoolUrl = `${this.baseUrl}/school?query=${searchInput}&lastItemId=${lastItemId}`;
    let result = this.http.get<any>(schoolUrl);
    return result;
  }

  getSchool(schoolId: number) {
    const schoolUrl = `${this.baseUrl}/school/${schoolId}`;
    let result = this.http.get<School>(schoolUrl);
    return result;
  }

  getReviews(schoolId: number) {
    const schoolUrl = `${this.baseUrl}/school/${schoolId}/review`;
    let result = this.http.get<Array<Review>>(schoolUrl);
    return result;
  }

  postReview(reviewRequest: ReviewRequest){
    const schoolUrl = `${this.baseUrl}/review`;
    let result = this.http.post<number>(schoolUrl, reviewRequest);
    return result;
  }
}
