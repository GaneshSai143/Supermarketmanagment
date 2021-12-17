import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetoutletbyidComponent } from './getoutletbyid.component';

describe('GetoutletbyidComponent', () => {
  let component: GetoutletbyidComponent;
  let fixture: ComponentFixture<GetoutletbyidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetoutletbyidComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetoutletbyidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
