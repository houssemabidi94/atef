import { Component, OnInit } from '@angular/core';
import { Score } from '../model/score';
import { AllEmployeesService } from '../Services/all-employees.service';

@Component({
  selector: 'app-scores',
  templateUrl: './scores.component.html',
  styleUrls: ['./scores.component.scss']
})
export class ScoresComponent implements OnInit {

score : Score[];

  constructor(public service : AllEmployeesService) { }

  ngOnInit() {
    this.getScore();
  }
getScore(){
  this.service.getUserScore().subscribe(data => 
    this.score = data
    )
}
}
