import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OutletadminComponent } from './outletadmin.component';

describe('OutletadminComponent', () => {
  let component: OutletadminComponent;
  let fixture: ComponentFixture<OutletadminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OutletadminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OutletadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
