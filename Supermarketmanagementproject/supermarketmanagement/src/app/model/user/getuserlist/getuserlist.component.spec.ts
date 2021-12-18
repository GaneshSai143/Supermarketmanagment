import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetuserlistComponent } from './getuserlist.component';

describe('GetuserlistComponent', () => {
  let component: GetuserlistComponent;
  let fixture: ComponentFixture<GetuserlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetuserlistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetuserlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
