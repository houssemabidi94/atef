import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'; 
import {AuthenticationService } from '../Services/authentication.service';
import { User } from '../model/user';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit {

  user = new User;
  invalidLogin =false;
  submitted = false;
  clicked = false;
  startworking = new Date();
  finishworking = new Date();

  constructor(public router : Router , private loginservice: AuthenticationService) { }

  ngOnInit() {

  } 


  verify(){
    (this.loginservice.authenticate(this.user.username, this.user.password).subscribe(
      data => {
        console.log(data);
        this.router.navigate(['/user/id']);
        console.log(this.startworking);

        this.invalidLogin = false;
      },
      error => {
        console.log(error);

        this.invalidLogin = true;
        this.router.navigate(['/notfound']);

  
      }
    )
    );
  }
onSubmit(invalid) {
  this.clicked=true;
  if(!invalid)
    this.verify();
  else{
    console.log("not valid");
    this.submitted = false;
  }
    
}
  }