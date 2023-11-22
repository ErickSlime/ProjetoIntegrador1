import { TestBed } from '@angular/core/testing';

import { TipoSoloService } from './tipo-solo.service';

describe('TipoSoloService', () => {
  let service: TipoSoloService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TipoSoloService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
