import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AllemployeesComponent } from '../allemployees/allemployees.component';
import { Score } from '../model/score';
import { AllEmployeesService } from '../Services/all-employees.service';
import { AuthenticationService, User } from '../Services/authentication.service';
import { PointageService } from '../Services/pointage.service';

@Component({
  selector: 'app-user-score',
  templateUrl: './user-score.component.html',
  styleUrls: ['./user-score.component.scss']
})
export class UserScoreComponent implements OnInit {
  score : Score[];
  user : User;
  constructor(private authservice : AuthenticationService , private router : Router,
    private pointageService : PointageService , private userS : AllEmployeesService) { }

  ngOnInit() {
    this.getUser();
  }
  onSignOut(){
    this.pointageService.pointageSortie();
    this.authservice.logOut();
    this.router.navigate(['/auth']);
  }
  getUser(){
    this.userS.getUserProfile().subscribe(data=>
      this.user = data)
  }
}
