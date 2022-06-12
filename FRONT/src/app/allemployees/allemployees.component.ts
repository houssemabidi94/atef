import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { AllEmployeesService } from '../Services/all-employees.service';


@Component({
  selector: 'app-allemployees',
  templateUrl: './allemployees.component.html',
  styleUrls: ['./allemployees.component.scss']
})
export class AllemployeesComponent implements OnInit {

  constructor(public employeeslistservice
    :AllEmployeesService) { }
  public displayedColumns = ['id','firstName', 'lastName', 'username', 'address','startTime',
  'endTime','daysoff','salary','nbabsence','nbdaysofdelay' ];

  employeeslist:Observable<User[]>;
  public dataSource = new MatTableDataSource<User>();

  ngOnInit() {
    console.log(this.employeeslist);
    this.employeeslistservice.getEmployees();
  }

}
