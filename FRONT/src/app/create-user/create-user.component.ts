import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { CreateUserService } from '../Services/create-user.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.scss']
})
export class CreateUserComponent implements OnInit {
  user : User = new User ();
  submitted = false;
  clicked = false;
  constructor(public router : Router ,private userService : CreateUserService) {}

  ngOnInit() {
   
  }
  save() { 
    console.log(this.user);
    this.userService.createUser(this.user)
    .subscribe(data =>{ 
      console.log(data);
      this.submitted=true;
      this.user = new User();},
       error =>{ console.log(error),this.submitted=false});
    // this.user = new User();
}
  onSubmit(invalid) {
    this.clicked=true;
    if(!invalid){
      this.save();
    }
    else{
      console.log("not valid");
      this.submitted = false;
    }
      
  }
}
