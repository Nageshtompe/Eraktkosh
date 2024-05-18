import { Component } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})


export class UserdashboardComponent {

constructor(public service:UserServiceService,private app:AppComponent){}

selectedNavbar:any=0;

show(num:any){
  this.selectedNavbar=num;
}
logout(){

  this.app.dashboard=0
  this.app.whatToShow=0
}
  


}
