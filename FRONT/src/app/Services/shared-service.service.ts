import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class SharedServiceService {

  private user = new Subject<User>();
  
    constructor() { }
  
    public getValue(): Observable<User> {
  
      return this.user;
  
    }
    public setValue(user: User): void {
      this.user.next(user);
    }

  }