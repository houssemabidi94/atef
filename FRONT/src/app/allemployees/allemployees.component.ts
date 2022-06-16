import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { AllEmployeesService } from '../Services/all-employees.service';
import { AuthenticationService } from '../Services/authentication.service';
import { PointageService } from '../Services/pointage.service';
import { SharedServiceService } from '../Services/shared-service.service';


@Component({
  selector: 'app-allemployees',
  templateUrl: './allemployees.component.html',
  styleUrls: ['./allemployees.component.scss']
})
export class AllemployeesComponent implements OnInit {

  user: User[];

  constructor(public employeeslistservice
    :AllEmployeesService  ,private authservice : AuthenticationService , private router : Router,
      private pointageService : PointageService,private shared : SharedServiceService) { }
  public displayedColumns = ['id','firstName', 'lastName', 'username', 'address','startTime',
  'endTime','daysoff','salary','nbabsence','nbdaysofdelay' ];

  public dataSource = new MatTableDataSource<User>();

  ngOnInit() {
    this.getListEmp();
  }
  getListEmp() {
    this.employeeslistservice.getEmployees().subscribe(data =>{
      this.user = data
    }
    )
  }
  onSignOut(){
    this.pointageService.pointageSortie();
    this.authservice.logOut();
    this.router.navigate(['/auth']);
  }
  setUser(){

  }
}
