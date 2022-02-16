import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OutletnameComponent } from './outletname.component';

describe('OutletnameComponent', () => {
  let component: OutletnameComponent;
  let fixture: ComponentFixture<OutletnameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OutletnameComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OutletnameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
