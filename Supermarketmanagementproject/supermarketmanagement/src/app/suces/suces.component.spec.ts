import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SucesComponent } from './suces.component';

describe('SucesComponent', () => {
  let component: SucesComponent;
  let fixture: ComponentFixture<SucesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SucesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SucesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
