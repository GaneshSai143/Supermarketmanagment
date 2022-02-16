import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderbyidComponent } from './orderbyid.component';

describe('OrderbyidComponent', () => {
  let component: OrderbyidComponent;
  let fixture: ComponentFixture<OrderbyidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderbyidComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderbyidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
