import { Component } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-rootdashboard',
  templateUrl: './rootdashboard.component.html',
  styleUrls: ['./rootdashboard.component.css']
})
export class RootdashboardComponent {

  constructor(public app:AppComponent){

  }

  view=0;

  show(num:number){
    this.view=num;
  }
  logoutroot(num:number){
    this.app.dashboard=num;
    this.app.whatToShow=0
  }
}
