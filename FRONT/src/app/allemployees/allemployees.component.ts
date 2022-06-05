import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import { User } from '../model/user';


@Component({
  selector: 'app-allemployees',
  templateUrl: './allemployees.component.html',
  styleUrls: ['./allemployees.component.scss']
})
export class AllemployeesComponent implements OnInit {

  constructor() { }
  public displayedColumns = ['id','firstName', 'lastName', 'username', 'address','startTime',
  'endTime','daysoff','salary','nbabsence','nbdaysofdelay' ];

  public dataSource = new MatTableDataSource<User>();

  ngOnInit() {
  }

}
