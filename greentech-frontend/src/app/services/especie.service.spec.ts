import { TestBed } from '@angular/core/testing';

import { EspecieService } from './especie.service';

describe('EspecieService', () => {
  let service: EspecieService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EspecieService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
