import { TestBed } from '@angular/core/testing';

import { PiloteInventaireHttpService } from './pilote-inventaire-http.service';

describe('PiloteInventaireHttpService', () => {
  let service: PiloteInventaireHttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PiloteInventaireHttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
