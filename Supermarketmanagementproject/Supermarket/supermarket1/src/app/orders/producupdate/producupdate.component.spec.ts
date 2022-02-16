import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProducupdateComponent } from './producupdate.component';

describe('ProducupdateComponent', () => {
  let component: ProducupdateComponent;
  let fixture: ComponentFixture<ProducupdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProducupdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProducupdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
