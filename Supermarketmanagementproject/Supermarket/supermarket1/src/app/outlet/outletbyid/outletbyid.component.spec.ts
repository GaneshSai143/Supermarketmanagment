import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OutletbyidComponent } from './outletbyid.component';

describe('OutletbyidComponent', () => {
  let component: OutletbyidComponent;
  let fixture: ComponentFixture<OutletbyidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OutletbyidComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OutletbyidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
