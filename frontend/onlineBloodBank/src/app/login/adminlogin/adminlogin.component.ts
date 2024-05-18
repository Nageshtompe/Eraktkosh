import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { UrlTree } from '@angular/router';
import { AppComponent } from 'src/app/app.component';
import { admin } from 'src/app/model/Admin';
import { UrlService } from 'src/app/services/url.service';
import { UserServiceService } from 'src/app/services/user-service.service';
import {FormGroup,FormControl,Validators,FormBuilder,AbstractControl}from '@angular/forms'




@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent {
  
  constructor(private http:HttpClient,private app:AppComponent,public url:UrlService){
    
  }

  registerBloodBankForm=new FormGroup({
    fullname:new FormControl('',[Validators.required]),
    username:new FormControl('',[Validators.required,Validators.minLength(5)]),
    password:new FormControl('',[Validators.required,Validators.pattern(/^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/)]),
    mobilenumber:new FormControl('',[Validators.required,Validators.pattern(/^[0-9]{10}$/)]),
    emailId:new FormControl('',[Validators.required,Validators.email,Validators.pattern(/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/)]),
    address:new FormControl('',[Validators.required]),
    city:new FormControl('',[Validators.required]),
  })

  get fullname(){
    return this.registerBloodBankForm.get('fullname')
  }
  get username(){
    return this.registerBloodBankForm.get('username')
  }
  get password(){
    return this.registerBloodBankForm.get('password')
  }
  get mobilenumber(){
    return this.registerBloodBankForm.get('mobilenumber')
  }
  get emailId(){
    return this.registerBloodBankForm.get('emailId')
  }
  get address(){
    return this.registerBloodBankForm.get('address')
  }
  get city(){
    return this.registerBloodBankForm.get('city')
  }



  baseUrl=this.url.getUrl();
//  baseUrl='http://13.232.198.136:8080/bloodbank06/'


  showloginorregister=0;
  adminusername='root';
  adminpassword='root';

 
  registeradmin:admin=new admin();
  
  show(num){
    this.showloginorregister=num;
  }
  regitseradmin(){

    this.http.post(this.baseUrl+'registerBank',this.registeradmin).subscribe(
      (data:any)=>
      {
        if(data==true)
        {
          alert("registration successfull");
          this.registeradmin=new admin();
          
        }
        else{
          alert("failed");
        }
      }
    );

  }
  adminlogin(){
    console.log();
    
    this.http.get(this.baseUrl+'banklogin'+this.adminusername+'/'+this.adminpassword).subscribe(
      (data:any)=>
      {
        if(data==1)
        {
          // alert("login succesfull");
          this.app.dashboard=2;
        }
        else if(data==2)
        {
         alert("credential not match");
        }else{
          alert("user not found");
        }
      }
    );

  }

  registerBank(){

    console.log(this.registerBloodBankForm.value);

    this.http.post(this.baseUrl+'CreateBloodBank',this.registerBloodBankForm.value).subscribe((data:any)=>
    {
      if(data==1)
      {
        window.alert("registration succeffully completed");
        this.registerBloodBankForm.reset();
      }
      else if(data==2)
      {
        window.alert("the username is already present")
      }
      else{
        window.alert("something error on server");
        
      }
    });
    
  }

  demo()
  {
    console.log(this.registerBloodBankForm.value);
    
  }
}
