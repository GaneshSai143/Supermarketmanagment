import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OutletsuccessComponent } from './outletsuccess.component';

describe('OutletsuccessComponent', () => {
  let component: OutletsuccessComponent;
  let fixture: ComponentFixture<OutletsuccessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OutletsuccessComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OutletsuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
