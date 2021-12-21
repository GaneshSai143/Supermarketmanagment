import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductsendemailComponent } from './productsendemail.component';

describe('ProductsendemailComponent', () => {
  let component: ProductsendemailComponent;
  let fixture: ComponentFixture<ProductsendemailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductsendemailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductsendemailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
