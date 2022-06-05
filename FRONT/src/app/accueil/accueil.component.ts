import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../Services/authentication.service';
import { PointageService } from '../Services/pointage.service';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.scss']
})
export class AccueilComponent implements OnInit {

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
