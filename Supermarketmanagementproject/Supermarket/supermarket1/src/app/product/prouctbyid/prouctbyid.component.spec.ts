import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProuctbyidComponent } from './prouctbyid.component';

describe('ProuctbyidComponent', () => {
  let component: ProuctbyidComponent;
  let fixture: ComponentFixture<ProuctbyidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProuctbyidComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProuctbyidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
