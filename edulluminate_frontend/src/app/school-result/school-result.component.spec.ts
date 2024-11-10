import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SchoolResultComponent } from './school-result.component';

describe('SchoolResultComponent', () => {
  let component: SchoolResultComponent;
  let fixture: ComponentFixture<SchoolResultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SchoolResultComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SchoolResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
