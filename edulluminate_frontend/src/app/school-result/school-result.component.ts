import { Component, Input } from '@angular/core';
import { School } from '../../types';
import {MatCardModule} from '@angular/material/card';
import { RouterModule, Router, NavigationEnd } from '@angular/router';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-school-result',
  standalone: true,
  imports: [MatCardModule, RouterModule, CommonModule],
  templateUrl: './school-result.component.html',
  styleUrl: './school-result.component.scss'
})
export class SchoolResultComponent {
  @Input() school!: School;


}

// https://stackoverflow.com/questions/38062702/how-to-pass-a-parameter-to-routerlink-that-is-somewhere-inside-the-url
