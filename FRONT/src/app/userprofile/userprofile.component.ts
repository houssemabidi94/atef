import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { AllEmployeesService } from '../Services/all-employees.service';
import { AuthenticationService } from '../Services/authentication.service';
import { PointageService } from '../Services/pointage.service';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.scss']
})
export class UserprofileComponent implements OnInit {

user : User = new User();

  constructor(
   private  employeeService : AllEmployeesService,private authservice : AuthenticationService , private router : Router,
    private pointageService : PointageService) { }
date=new Date();
  ngOnInit() {
    this.getUserProfile();
}
  public displayedColumns = ['id','firstName', 'lastName', 'username', 'address','startTime',
  'endTime','daysoff','salary','nbabsence','nbdaysofdelay' ];

  public dataSource = new MatTableDataSource<User>();
  getUserProfile(){
    this.employeeService.getUserProfile().subscribe(data =>
      this.user = data
    );
  }
  onSignOut(){
    this.pointageService.pointageSortie();
    this.authservice.logOut();
    this.router.navigate(['/auth']);
  }
}