import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetoutletComponent } from './getoutlet.component';

describe('GetoutletComponent', () => {
  let component: GetoutletComponent;
  let fixture: ComponentFixture<GetoutletComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetoutletComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetoutletComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
