import { TestBed } from '@angular/core/testing';

import { PragaService } from './praga.service';

describe('PragaService', () => {
  let service: PragaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PragaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
