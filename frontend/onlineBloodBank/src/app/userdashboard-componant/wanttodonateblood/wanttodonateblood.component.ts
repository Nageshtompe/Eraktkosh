import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { appoinmentForBlood } from 'src/app/model/appointmentForBlood';
import { UrlService } from 'src/app/services/url.service';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-wanttodonateblood',
  templateUrl: './wanttodonateblood.component.html',
  styleUrls: ['./wanttodonateblood.component.css']
})
export class WanttodonatebloodComponent {

  appointment:appoinmentForBlood[]=[];

  confirmAppointment:appoinmentForBlood[]=[];




  bloodDonationForm:FormGroup;
  show=0; //1-showing the blood apponment form
          //2- showing the appoinment status
      
    onClick(num:any)
    {
      this.show=num;
    }

  constructor(private fb: FormBuilder,public http:HttpClient,private service:UserServiceService,public url:UrlService) {
    this.createForm();
  }

  createForm() {
    this.bloodDonationForm = this.fb.group({
      fullName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', Validators.required],
      bloodType: ['', Validators.required],
      preferredDate: ['', Validators.required],
      healthConditions: ['']
    });
  }

  baseUrl=this.url.getUrl();
  // baseUrl='http://13.232.198.136:8080/bloodbank06/'

  submitForm() {
    if (this.bloodDonationForm.valid) {
      // Handle form submission logic here
      let num=this.service.getUserData().id;
      console.log(num);
      
      this.http.post(this.baseUrl+"donateAppointment"+this.service.getUserData().id,this.bloodDonationForm.value).subscribe(
        (data:any)=>{
        if(data==true)
        {
          window.alert("done");
          this.clearForm();
        }
        else
        window.alert("fail");
        })
      console.log('Form submitted:', this.bloodDonationForm.value);
      // You may want to send the data to the server using HttpClient
    } else {
      // Validate and display custom error messages
      window.alert("fill the all data..")
      this.validateForm(this.bloodDonationForm);
    }
  }

  clearForm(){
    this.bloodDonationForm.reset();
  }

  validateForm(formGroup: FormGroup) {
    Object.keys(formGroup.controls).forEach(controlName => {
      const control = formGroup.get(controlName);
      if (control instanceof FormGroup) {
        this.validateForm(control);
      } else {
        control.markAsTouched({ onlySelf: true });
      }
    });
  }

  // getErrorMessage(controlName: string): string {
  //   const control = this.bloodDonationForm.get(controlName);

  //   for (const errorKey in control.errors) {
  //     if (control.errors.hasOwnProperty(errorKey) && this.validationMessages[controlName][errorKey]) {
  //       return this.validationMessages[controlName][errorKey];
  //     }
  //   }

  //   return '';
  // }

  // // Define error messages or labels
  // validationMessages = {
  //   fullName: {
  //     required: 'Full Name is required.'
  //   },
  //   email: {
  //     required: 'Email is required.',
  //     email: 'Please enter a valid email address.'
  //   },
  //   phone: {
  //     required: 'Phone Number is required.'
  //   },
  //   bloodType: {
  //     required: 'Blood Type is required.'
  //   },
  //   preferredDate: {
  //     required: 'Preferred Date is required.'
  //   }
  // };

  getAllAppointment()
  {
    this.http.get(this.baseUrl+'getAppointmentList'+this.service.getUserData().id).subscribe(
      (data:any)=>
      {
        if(data!=null)
        {
          this.appointment=data;
        }
        else
        {
          window.alert("something error");
        }
      },error=>
      {
        console.log("roorrrrrrrrr ");
        

      }

    );

  }

  cancelAppointment(request:any)
  {
    console.log(request.id);
    console.log(this.service.getUserData().id);
    this.http.get(this.baseUrl+"cancelAppointment"+request.id+"and"+this.service.getUserData().id).subscribe(
      (data:any)=>
      {
        if(data)
        {
          let index=this.appointment.indexOf(request);
          this.appointment.splice(index,1);
        }
        else
        {
          window.alert("something error")
        }
      }
    );
    
    
  }

  getConfirmAppointment()
  {
    this.http.get(this.baseUrl+'getConfirmAppointmentList'+this.service.getUserData().id).subscribe(
      (data:any)=>
      {
        if(data!=null)
        {
          this.confirmAppointment=data;
        }
        else
        {
          window.alert("something error");
        }
      }

    );

  }


}
  

