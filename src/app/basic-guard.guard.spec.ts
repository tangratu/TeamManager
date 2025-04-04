import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { basicGuardGuard } from './basic-guard.guard';

describe('basicGuardGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => basicGuardGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
