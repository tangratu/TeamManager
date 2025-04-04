import { CanActivateFn } from '@angular/router';
import {RegisterService} from './register.service';
import {inject} from '@angular/core';
import {Router} from '@angular/router';

export const basicGuardGuard: CanActivateFn = () => {
  const service : RegisterService = inject(RegisterService);
  const router : Router = inject(Router);
  if(service.authenticate()){
	  return true;
  }
  router.navigate(['/registration']);
  return false;
};
