import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class AllEmployeesService {

  private baseUrl = 'http://localhost:8085/employee/1';
  results: [];
  info: {};

  constructor(private http: HttpClient) { }


  getEmployees():Observable<User>
  {
    return this.http.get<User>(`${this.baseUrl}`);
     }
}
