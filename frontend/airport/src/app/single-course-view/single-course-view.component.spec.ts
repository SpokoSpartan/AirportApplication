import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SingleCourseViewComponent } from './single-course-view.component';

describe('SingleCourseViewComponent', () => {
  let component: SingleCourseViewComponent;
  let fixture: ComponentFixture<SingleCourseViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SingleCourseViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SingleCourseViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
