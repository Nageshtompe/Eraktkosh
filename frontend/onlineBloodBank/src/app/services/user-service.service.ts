import { EventEmitter, Injectable } from '@angular/core';
import { UIUserData } from '../model/UIUserData';
import { HttpBackend, HttpClient } from '@angular/common/http';
import { AppComponent } from '../app.component';
import { UrlService } from './url.service';
import { useAnimation } from '@angular/animations';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private User:UIUserData,private http:HttpClient,public url:UrlService) { }

  showValueChanged = new EventEmitter<number>();


  appointmentIDForActionForm:number;

  getAppointmentID(){
    return this.appointmentIDForActionForm;
  }

  setAppointmentID(id:number)
  {
    this.appointmentIDForActionForm=id;
  }


//  private userData:any;
  private userData:UIUserData=new UIUserData();

  baseUrl=this.url.getUrl();
  //  baseUrl='http://13.232.198.136:8080/bloodbank06/'


  
  getUserData()
  {
    return this.userData;
  }
getRole(){
 return this.userData.role;
}
  
  
  
  saveUserData(UIUsername:any)
  {
    this.http.get(this.baseUrl+'getDonorData'+UIUsername).subscribe(
      (data:any)=>
      {    
        this.userData=data;
        console.log(data);
        
      }
      
      );
    }
}
