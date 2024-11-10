import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookService } from '../../services/api/book/book.service';
import { Chapter } from '../../../types';
// import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';

@Component({
  selector: 'app-chapter',
  standalone: true,
  imports: [MatCardModule],
  templateUrl: './chapter.component.html',
  styleUrl: './chapter.component.scss'
})
export class ChapterComponent implements OnInit {
  chapter: Chapter = {
      id: -1,
      chapterOrder: -1,
      title: '',
      content: ''
  };

  constructor(
    private route: ActivatedRoute,
    private bookService: BookService
  ){}

  ngOnInit(): void {

    // if(this.route.parent !== null) {
    //   this.route.parent.params.subscribe((params) => {
    //     this.bookService.getChapter(params['chapterId'])
    //       .subscribe(chapter => this.chapter = chapter);
    //   })
    // }
    // this.route.parent!.params.subscribe(
    //   (params) => 
    //   { 
    //                console.log(params); 
    //    });


    // // const bookId = Number(this.route.snapshot.paramMap.get('bookId'));
    const chapterId = Number(this.route.snapshot.paramMap.get('chapterId'));
    
    this.bookService.getChapter(chapterId)
      .subscribe(chapter => this.chapter = chapter);
  }
}
