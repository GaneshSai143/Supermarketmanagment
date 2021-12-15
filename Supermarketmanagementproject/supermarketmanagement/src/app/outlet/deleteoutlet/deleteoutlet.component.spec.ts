import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteoutletComponent } from './deleteoutlet.component';

describe('DeleteoutletComponent', () => {
  let component: DeleteoutletComponent;
  let fixture: ComponentFixture<DeleteoutletComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteoutletComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteoutletComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
