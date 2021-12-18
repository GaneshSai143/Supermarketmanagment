import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetproductbyidComponent } from './getproductbyid.component';

describe('GetproductbyidComponent', () => {
  let component: GetproductbyidComponent;
  let fixture: ComponentFixture<GetproductbyidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetproductbyidComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetproductbyidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
