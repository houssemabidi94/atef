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


  getEmployees():Observable<any>
  {
    return this.http.get<any[]>("http://localhost:8085/allusers");
     }

     getUserProfile():Observable<any>
     {
       return this.http.get<any[]>("http://localhost:8085/user");
     }

     getUserScore() : Observable<any>
     {
      return this.http.get<any[]>("http://localhost:8085/scores");
     }

     getUserScoreById(id : number) : Observable<any>
     {
      return this.http.get<any[]>("http://localhost:8085/scores/" +id);
     }
}
