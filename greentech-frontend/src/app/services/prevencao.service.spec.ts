import { TestBed } from '@angular/core/testing';

import { PrevencaoService } from './prevencao.service';

describe('PrevencaoService', () => {
  let service: PrevencaoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PrevencaoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
