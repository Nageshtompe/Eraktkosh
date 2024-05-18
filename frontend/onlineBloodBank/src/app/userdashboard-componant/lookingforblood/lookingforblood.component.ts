import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { BloodRequestForm } from 'src/app/model/BloodRequestForm';
import { UrlService } from 'src/app/services/url.service';
import { UserServiceService } from 'src/app/services/user-service.service';
import { FormBuilder, FormControl, FormGroup, Validators ,AbstractControl} from '@angular/forms';


const ageValidator = (control: AbstractControl) => {
  const value = control.value;
  if (value != null && value < 0) {
    return { negative: true };
  }
  return null;
};



@Component({
  selector: 'app-lookingforblood',
  templateUrl: './lookingforblood.component.html',
  styleUrls: ['./lookingforblood.component.css']
})
export class LookingforbloodComponent {

  constructor(private http:HttpClient,private service:UserServiceService,private app:AppComponent,public url:UrlService,private formBuilder: FormBuilder){}
  bloodRequestForm:number=0;  

  formData=new FormGroup({
    patientName: new FormControl('',Validators.required),
    patientAge: new FormControl('', [Validators.required, ageValidator]),
    patientGender:new FormControl('',Validators.required),
    hospitalName:new FormControl('',Validators.required),
    hospitalContactNumber: new FormControl('', [Validators.required, Validators.pattern(/^\d{10}$/)]),   
    bloodType:new FormControl('',Validators.required),
    neededDate:new FormControl('',Validators.required),
    emergencyStatus:new FormControl('',Validators.required),
    patientContactNumber:new FormControl('', [Validators.required, Validators.pattern(/^\d{10}$/)])
    
  })

  statusOfBlood:BloodRequestForm[]=[];
  bloodRequestdata:BloodRequestForm=new BloodRequestForm();

  baseUrl=this.url.getUrl();
  // baseUrl='http://13.232.198.136:8080/bloodbank06/'

  show(num:any)
  {
    this.bloodRequestForm=num;
  }

  demo(){
    console.log(this.formData.value);
    
  }



  saveBloodRequestData(){
    console.log(this.formData.value);
    this.http.post(this.baseUrl+'requestForBlood'+this.service.getUserData().id,this.formData.value).subscribe(
      (data:any)=>{
        if(data)
        {
          alert("request send successfull...");
          this.formData.reset();
          // this.bloodRequestdata=new BloodRequestForm();
        }
        else
        {
          alert("server not responding...");
        }

      }
    );
    
    
  }

  statusOfBloodRequest(){
console.log("in done");
console.log(this.service.getUserData().id);


    this.http.get(this.baseUrl+'statusOfBloodRequest'+this.service.getUserData().id).subscribe(
      (data:any)=>
      {
        if(data!=null)
        {
          console.log(data); 
          this.statusOfBlood=data;
        }
        else
        {
          alert("something wrong....")
        }
      }
    );

  }

  
  

}
