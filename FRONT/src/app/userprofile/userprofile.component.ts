import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { User } from '../model/user';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.scss']
})
export class UserprofileComponent implements OnInit {

  constructor() { }
date=new Date();
  ngOnInit() {
  }
  public displayedColumns = ['id','firstName', 'lastName', 'username', 'address','startTime',
  'endTime','daysoff','salary','nbabsence','nbdaysofdelay' ];

  public dataSource = new MatTableDataSource<User>();

}
