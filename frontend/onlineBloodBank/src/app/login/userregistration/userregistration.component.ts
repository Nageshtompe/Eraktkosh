import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators ,AbstractControl} from '@angular/forms';
import { AppComponent } from 'src/app/app.component';
import { User } from 'src/app/model/User';
import { UrlService } from 'src/app/services/url.service';
import { ReactiveFormsModule } from '@angular/forms';
import { UserServiceService } from 'src/app/services/user-service.service';

function dateOfBirthValidator(control: AbstractControl): { [key: string]: boolean } | null {
  if (control.value) {
    const currentDate = new Date();
    const dob = new Date(control.value);
    const age = currentDate.getFullYear() - dob.getFullYear();

    if (age < 18) {
      return { 'underage': true };
    }
  }

  return null;
}

@Component({
  selector: 'app-userregistration',
  templateUrl: './userregistration.component.html',
  styleUrls: ['./userregistration.component.css']
})

export class UserregistrationComponent {

  constructor(private http: HttpClient, private app: AppComponent, public url: UrlService, private formBuilder: FormBuilder) {

    this.registerForm = this.formBuilder.group({
      fullname: ['', [Validators.required]],
      username: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(6)]],
     
      emailId: ['', [Validators.required, Validators.email]],
      mobilenumber: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      dob: ['', [Validators.required,dateOfBirthValidator]],
      gender: ['', [Validators.required]],
      address: ['', [Validators.required]],
      city:['',[Validators.required]]
    });

  }


  registerForm: FormGroup;
  showPopup: boolean = false;

  baseUrl = this.url.getUrl();
  // baseUrl='http://13.232.198.136:8080/bloodbank06/'


  registerUser: User = new User();

  onRegisterClick() {
    if (this.registerForm.invalid) {
      // Show the popup if the form is invalid
      this.showPopup = true;
    } else {
      // Perform the registration logic if the form is valid
      this.register();
    }
  }

  closePopup() {
    // Close the popup
    this.showPopup = false;
  }



  register() {

    if(this.registerForm.valid)
    {
      const formData = this.registerForm.value;
      console.log(formData);
      this.http.post(this.baseUrl + 'register',formData).subscribe(
            (data: any) => {
              if (data == '1') {
                alert("registration successfull");
                // this.registerUser = new User();
                this.app.whatToShow = 1;
                this.registerForm.reset();
              }
              else if(data=='2'){
                alert("User already registered");
              }
              else if(data=='0')
              {
                alert("something error");
              }
              else
              {
                alert("dekh")
              }
            }
          );
      
    }
    else {
      this.showPopup = true;
    }

  }
  
}

    // if (this.registerUser.fullname == "" || this.registerUser.username == "" || this.registerUser.password == "" || this.registerUser.address == "" || this.registerUser.bloodgroup == "" || this.registerUser.emailId == "" || this.registerUser.gender == "" || this.registerUser.mobilenumber == null) {
    //   alert("fill all data");
    // } else {
    //   console.log(this.registerUser);
    //   this.http.post(this.baseUrl + 'register', this.registerUser).subscribe(
    //     (data: any) => {
    //       if (data == true) {
    //         alert("registration successfull");
    //         this.registerUser = new User();
    //         this.app.whatToShow = 1;
    //       }
    //       else {
    //         alert("failed");
    //       }
    //     }
    //   );
    // }
