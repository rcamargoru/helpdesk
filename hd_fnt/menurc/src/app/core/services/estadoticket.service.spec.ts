import { TestBed } from '@angular/core/testing';

import { EstadoticketService } from './estadoticket.service';

describe('EstadoticketService', () => {
  let service: EstadoticketService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EstadoticketService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
