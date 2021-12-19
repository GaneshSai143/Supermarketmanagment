import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateproductsendmailComponent } from './updateproductsendmail.component';

describe('UpdateproductsendmailComponent', () => {
  let component: UpdateproductsendmailComponent;
  let fixture: ComponentFixture<UpdateproductsendmailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateproductsendmailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateproductsendmailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
