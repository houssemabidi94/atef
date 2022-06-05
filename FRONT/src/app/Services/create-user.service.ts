import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CreateUserService {
  private baseUrl = 'http://localhost:8085/register';
  constructor(private http: HttpClient) { }

  createUser(user: Object): Observable<Object> {

    return this.http.post(`${this.baseUrl}`, user);
  }

}
