import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SchoolReviewComponent } from './school-review.component';

describe('SchoolReviewComponent', () => {
  let component: SchoolReviewComponent;
  let fixture: ComponentFixture<SchoolReviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SchoolReviewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SchoolReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
