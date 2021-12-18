import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpateproductComponent } from './upateproduct.component';

describe('UpateproductComponent', () => {
  let component: UpateproductComponent;
  let fixture: ComponentFixture<UpateproductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpateproductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpateproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
