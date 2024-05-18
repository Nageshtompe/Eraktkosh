import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { HistoryData } from 'src/app/model/HistoryData';
import { UrlService } from 'src/app/services/url.service';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-donor-history',
  templateUrl: './donor-history.component.html',
  styleUrls: ['./donor-history.component.css']
})
export class DonorHistoryComponent {

  constructor(public http:HttpClient,public service:UserServiceService,public url:UrlService){}
  baseUrl=this.url.getUrl();
  //  baseUrl='http://13.232.198.136:8080/bloodbank06/'

  show=0      //1-shows the history of blood donoting
  showAdditionalButtons = false; 

  his:HistoryData=new HistoryData();

  bloodHistory:HistoryData[]=[];

  getHistory(){
    this.http.get(this.baseUrl+'getAllHistoryOfBloodDonorFromDB'+this.service.getUserData().id).subscribe(
      (data:any)=>
      {
        if(data!=null)
        {
          this.show=1;
          this.bloodHistory=data;
        }
      }
    );
  }

  

  

  
  
}
