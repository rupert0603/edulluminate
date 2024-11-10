import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WriteReviewSnackbarComponent } from './write-review-snackbar.component';

describe('WriteReviewSnackbarComponent', () => {
  let component: WriteReviewSnackbarComponent;
  let fixture: ComponentFixture<WriteReviewSnackbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WriteReviewSnackbarComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WriteReviewSnackbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
