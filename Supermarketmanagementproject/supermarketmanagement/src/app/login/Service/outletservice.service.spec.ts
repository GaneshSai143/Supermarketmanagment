import { TestBed } from '@angular/core/testing';

import { OutletserviceService } from './outletservice.service';

describe('OutletserviceService', () => {
  let service: OutletserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OutletserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
