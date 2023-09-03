import {Injectable} from '@angular/core';
import {CanActivate} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CanNavigateToAdminGuard implements CanActivate {
  accessGranted = false;

  canActivate(): boolean {
    if(!this.accessGranted) {
      const question = $localize`:@@CanNavigateToAdminGuard\:question:Sie Sie ein Admin?`;
      this.accessGranted = window.confirm(question);
    }
    return this.accessGranted;
  }

}
