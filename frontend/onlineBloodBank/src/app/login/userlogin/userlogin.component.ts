import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { UserdashboardComponent } from 'src/app/dashboard/userdashboard/userdashboard.component';
import { UIUserData } from 'src/app/model/UIUserData';
import { UrlService } from 'src/app/services/url.service';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent {

  constructor(private http:HttpClient,private app:AppComponent,private service:UserServiceService,public url:UrlService)
  {

  }
  formData: any = {};
  UIUsername:String="";
  UIPassword:String="";

 

  // onSubmit(){

  // }
  baseUrl=this.url.getUrl();
  // baseUrl='http://13.232.198.136:8080/bloodbank06/'



  login(){    
      this.http.get(this.baseUrl+'login'+this.UIUsername+'and'+this.UIPassword).subscribe(
    (data:any)=>
    {
      if(data==11)
      {
        this.service.saveUserData(this.UIUsername);
        this.app.dashboard=1;
      }else if(data==33)
      {
        this.service.saveUserData(this.UIUsername);
        this.app.dashboard=3;
      }else if(data==22){
        this.service.saveUserData(this.UIUsername);
        this.app.dashboard=2
      }
      else if(data==0)
      {
        // console.log(data);
        
        alert("User not found");
      }
      else if(data==2)
      {
        alert("wrong password entered")
      }
      else
      {
        alert("something wrong")
      }
    }
    );
    
  }


// login() {
//   // Your login logic goes here
//   if (this.UIUsername === 'your_username' && this.UIPassword === 'your_password') {
//     // Successful login logic
//     console.log('Login successful!');
//   } else {
//     // Failed login logic
//     console.log('Login failed. Invalid username or password.');
//   }
// }

}
