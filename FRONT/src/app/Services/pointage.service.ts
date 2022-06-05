import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PointageService {

  private baseUrl = 'http://localhost:8085/';

  constructor(private http: HttpClient) { }

  pointageSortie(){
    let uri = "pointageSortie";
    this.http.put(this.baseUrl+uri,null);
  }
}
