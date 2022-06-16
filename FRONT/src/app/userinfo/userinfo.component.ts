import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../Services/authentication.service';
import { PointageService } from '../Services/pointage.service';

@Component({
  selector: 'app-userinfo',
  templateUrl: './userinfo.component.html',
  styleUrls: ['./userinfo.component.scss']
})
export class UserinfoComponent implements OnInit {

  constructor(private authservice : AuthenticationService , private router : Router,
    private pointageService : PointageService) { }

  ngOnInit() {
  }
  onSignOut(){
    this.pointageService.pointageSortie();
    this.authservice.logOut();
    this.router.navigate(['/auth']);
  }
}
