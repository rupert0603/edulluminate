import { Component, inject } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBarLabel, MatSnackBarActions, MatSnackBarAction, MatSnackBarRef } from '@angular/material/snack-bar';

@Component({
  selector: 'app-write-review-snackbar',
  standalone: true,
  imports: [MatButtonModule, MatSnackBarLabel, MatSnackBarActions, MatSnackBarAction],
  templateUrl: './write-review-snackbar.component.html',
  styleUrl: './write-review-snackbar.component.scss'
})
export class WriteReviewSnackbarComponent {

  snackBarRef = inject(MatSnackBarRef);

}
