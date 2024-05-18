import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { User } from 'src/app/model/User';
import { UrlService } from 'src/app/services/url.service';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent {
  constructor(private app:AppComponent,private http:HttpClient,public service:UserServiceService,public url:UrlService){
    this.service.showValueChanged.subscribe((value: number) => {
      this.show = value;
    });
  }

  show=0;

  baseUrl=this.url.getUrl();
//  baseUrl='http://13.232.198.136:8080/bloodbank06/'
  showDropdown=false;

  onBack() {
    // Your logic here
    this.show = 3;
    // Emit the value change to notify other components
    this.service.showValueChanged.emit(this.show);
  }

  public appointmentdata:any[]=[];

  

   //1-show donor list   2-request of blood 3-appointment 4-actionForm

  logout()
  {
    this.app.dashboard=0
    this.app.whatToShow=0
  }

  user:User[]=[];

  getAllDonor(){


    this.show=1;
    this.http.get(this.baseUrl+'getDonorDataForAdminDashboard').subscribe(
      (data:any)=>
      {

        this.user=data;

      }
    );


  }
  reqOfBlood(){
    this.show=2
  }

  getAllAppointment(){

    this.http.get(this.baseUrl+'getAllDonorsAppointments').subscribe(
      (data:any)=>
      {
        this.appointmentdata=data;
      }
    );
    console.log("in methid");
    this.show=3
  }

  messageOnConfirm:string;
  onConfirm(ap:any)
  {
    console.log(ap);
    console.log(this.messageOnConfirm);
    
    
  }


  sendDataToBackend(ap: any) {

    this.http.get(this.baseUrl+"changeAppointmentStaus"+ap.id).subscribe(
      (data:any)=>
      {
        if(data)
        {
          // let index=this.appointmentdata.indexOf(ap);
          ap.status="confirm";
          window.alert("th appointment is confirmed..!");
        }
        else
        {
          window.alert("something error");
        }
      }
    );
    console.log(ap.id);
    
  }
  
  message:string;

  showActionForm(id:number)
  {
    // console.log(id);
    
    this.service.setAppointmentID(id);
    this.show=4;

  }


}
