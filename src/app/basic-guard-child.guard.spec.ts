import { TestBed } from '@angular/core/testing';
import { CanActivateChildFn } from '@angular/router';

import { basicGuardChildGuard } from './basic-guard-child.guard';

describe('basicGuardChildGuard', () => {
  const executeGuard: CanActivateChildFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => basicGuardChildGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
