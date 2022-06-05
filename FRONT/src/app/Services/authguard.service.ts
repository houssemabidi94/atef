import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';
@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {
  constructor(private authService :AuthenticationService, private router:Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) { 
     /*  if (this.authService.isAuth){
        return true; 
      }
      else 
      {this.router.navigate(['/auth']); }
      } */
             if (this.authService.isUserLoggedIn()){
        return true; 
      }
      else 
      {this.router.navigate(['/auth']);
      return false ;
    }
      } 
}

