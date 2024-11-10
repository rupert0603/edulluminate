import { Component, OnInit } from '@angular/core';
import {MatTabsModule} from '@angular/material/tabs';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Router } from '@angular/router';
import { ChapterComponent } from '../chapter/chapter.component';
import { QuestionsComponent } from '../questions/questions.component';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [RouterOutlet, MatTabsModule, ChapterComponent, QuestionsComponent],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.scss'
})
export class MenuComponent implements OnInit {
  // tabShown = ''
  indexOfTabShown = 0;

  constructor(private router: Router, private route: ActivatedRoute){}

  ngOnInit(){
    // console.log(this.route.snapshot.url);
    // this.tabShown = this.route.snapshot.url[0].path;
    if(this.route.snapshot.url[0].path === "questions") {
      this.indexOfTabShown = 1;      
    } else {
      this.indexOfTabShown = 0;
    }
  }

  onClick($event: any) {
    if($event.index === 0) {
      this.router.navigate(['../chapter-companion'], { relativeTo: this.route });
    } else {
      this.router.navigate(['../questions'], { relativeTo: this.route })
    }
    
  }
}
