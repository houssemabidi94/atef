import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class BasicAuthHttpInterceptorService implements HttpInterceptor {

  constructor() {
    console.log('gggg')
   }
  

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    console.log('gggg')

    if (localStorage.getItem('username') && localStorage.getItem('token')) {
      console.log('###',localStorage.getItem('token'))
      const headerss = {
        'Content-type' : 'application/json',
        'Accept': 'application/json',
        'Authorization' : localStorage.getItem('token')
      }
      req = req.clone({
        setHeaders: headerss
      })
    }
    return next.handle(req);
  }
}
