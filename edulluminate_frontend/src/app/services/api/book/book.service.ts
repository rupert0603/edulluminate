import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Answer, BookSummary, Chapter, Question } from '../../../../types';
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private baseUrl = environment.bookServiceBaseUrl;
  constructor(
    private http: HttpClient
  ) { }

  getBookSummary(bookId: number) {
    const url = `${this.baseUrl}/book/${bookId}/chapter`;
    return this.http.get<BookSummary>(url);
  }

  // https://stackoverflow.com/questions/39325503/how-to-pass-data-between-two-components-in-angular-2

  getQuestions(chapterId: number, page: number) {
    const url = `${this.baseUrl}/chapter/${chapterId}/question?page=${page}`;
    return this.http.get<Array<Question>>(url);
  }

  getAnswers(questionId: number) {
    const url = `${this.baseUrl}/question/${questionId}/answer`;
    return this.http.get<Array<Answer>>(url);
  }

  getChapter(chapterId: number) {
    const url = `${this.baseUrl}/chapter/${chapterId}`;
    return this.http.get<Chapter>(url);
  }
}
