import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketBoughtComponent } from './ticket-bought.component';

describe('TicketBoughtComponent', () => {
  let component: TicketBoughtComponent;
  let fixture: ComponentFixture<TicketBoughtComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TicketBoughtComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TicketBoughtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
