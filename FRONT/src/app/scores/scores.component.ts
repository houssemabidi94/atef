import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Score } from '../model/score';
import { User } from '../model/user';
import { AllEmployeesService } from '../Services/all-employees.service';
import { AuthenticationService } from '../Services/authentication.service';
import { PointageService } from '../Services/pointage.service';

@Component({
  selector: 'app-scores',
  templateUrl: './scores.component.html',
  styleUrls: ['./scores.component.scss']
})
export class ScoresComponent implements OnInit {

score : Score[];
user : User;
  constructor(public service : AllEmployeesService ,private authservice : AuthenticationService , private router : Router,
    private pointageService : PointageService) 
    { }

  ngOnInit() {
    this.getScore();
    this.getUser();
  }
getScore(){
  this.service.getUserScore().subscribe(data => 
    this.score = data
    )
}
onSignOut(){
  this.pointageService.pointageSortie();
  this.authservice.logOut();
  this.router.navigate(['/auth']);
}
getUser(){
  this.service.getUserProfile().subscribe(data=>
    this.user = data)
}
}
