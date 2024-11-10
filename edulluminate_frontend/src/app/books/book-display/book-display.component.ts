import { Component, OnInit } from '@angular/core';
import { RouterModule, Router, NavigationEnd } from '@angular/router';
import { BookSummary } from '../../../types';
import { BookService } from '../../services/api/book/book.service';
import { SidebarService } from '../../services/data-transfer/sidebar.service';

import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';

@Component({
  selector: 'app-book-display',
  standalone: true,
  imports: [MatButtonModule, MatCardModule, RouterModule],
  templateUrl: './book-display.component.html',
  styleUrl: './book-display.component.scss'
})
export class BookDisplayComponent implements OnInit {
  bookSummary: BookSummary = {
    id: -1,
    name: '',
    isbn: '',
    imageUrl: '',
    authors: [],
    chapters: []
  }

  constructor(
    private bookService: BookService,
    // private sideBarTransferService: SidebarService
  ){}

  ngOnInit(): void {
    this.getBookSummary();
  }

  getBookSummary() {
    this.bookService.getBookSummary(1)
      .subscribe(bookSummary => this.bookSummary = bookSummary);
  }

// https://stackoverflow.com/questions/39325503/how-to-pass-data-between-two-components-in-angular-2
}
