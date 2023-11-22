import { TestBed } from '@angular/core/testing';

import { DicaService } from './dica.service';

describe('DicaService', () => {
  let service: DicaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DicaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
