import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../Services/authentication.service';
import { PointageService } from '../Services/pointage.service';

@Component({
  selector: 'app-rhprofile',
  templateUrl: './rhprofile.component.html',
  styleUrls: ['./rhprofile.component.scss']
})
export class RhprofileComponent implements OnInit {

  constructor(private authservice : AuthenticationService , private router : Router,
    private pointageService : PointageService) { }
date = new Date();
  ngOnInit() {
  }
  onSignOut(){
    this.pointageService.pointageSortie();
    this.authservice.logOut();
    this.router.navigate(['/auth']);
  }
}
