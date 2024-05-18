import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { UrlService } from 'src/app/services/url.service';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent {

  constructor(private http:HttpClient,private app:AppComponent,public url:UrlService){
    
    
  }

//baseUrl='http://localhost:8080/'
baseUrl='http://13.232.198.136:8080/bloodbank06/'

  registeredDonor=0;
  BloodUnitCollected=0;
  ApprovedCamp=0;
  RegisteredBloodBank=0;


  currentDate = new Date();

  onMouseOver(event: MouseEvent): void {
    // Your code to handle the mouseover event

    this.http.get(this.url.getUrl()+'countOfDonor'+1).subscribe(
      (data:any)=>
      {
        this.registeredDonor=data;
        // console.log(data);
        
      }
    );
    this.http.get(this.baseUrl+'getCountOfCollectedBlood').subscribe(
      (data:any)=>
      {
       this.BloodUnitCollected=data; 
      }
    );
    this.http.get(this.url.getUrl()+'countOfDonor'+2).subscribe(
      (data:any)=>
      {
        this.RegisteredBloodBank=data;
        // console.log(data);
        
      }
    );

  }
  




}
