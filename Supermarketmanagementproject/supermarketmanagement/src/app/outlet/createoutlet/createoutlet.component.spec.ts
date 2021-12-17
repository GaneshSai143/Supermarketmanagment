import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateoutletComponent } from './createoutlet.component';

describe('CreateoutletComponent', () => {
  let component: CreateoutletComponent;
  let fixture: ComponentFixture<CreateoutletComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateoutletComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateoutletComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
