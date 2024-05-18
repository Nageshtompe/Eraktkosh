import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { UrlService } from 'src/app/services/url.service';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-action-form',
  templateUrl: './action-form.component.html',
  styleUrls: ['./action-form.component.css']
})
export class ActionFormComponent {

  constructor(public service:UserServiceService,private http:HttpClient,public url:UrlService)
  {
   
  }

  baseUrl=this.url.getUrl();
  // baseUrl='http://13.232.198.136:8080/bloodbank06/'



  model = {
    name: '',
    age: null,
    healthCondition: '',
    bloodGroup: '',
    bloodQuantity: null,
    // dateOfDonating: null,
    weight: null,
    donorIdProof: '',
    documentType: '',
    donorIddentityNumber: ''
  };

  
  

  onSubmit() {
    // Handle form submission logic here, e.g., send data to the backend
    console.log(this.model);

    let appointmentID=this.service.getAppointmentID();

    this.http.post(this.baseUrl+'actionFormSubmited'+appointmentID,this.model).subscribe(
      (data:any)=>
      {
        if(data)
        {
          window.alert("succeefull");
          this.model={
                      
              name: '',
              age: null,
              healthCondition: '',
              bloodGroup: '',
              bloodQuantity: null,
              // dateOfDonating: null,
              weight: null,
              donorIdProof: '',
              documentType: '',
              donorIddentityNumber: ''
            };
            this.callOnBack();

        }
        else
        {
          window.alert("fail");
        }
      },
      error=>
      {
        console.error('Error:', error);
        window.alert('An error occurred');
      }
    ); 
  }
  
  callOnBack() {
    // Call the onBack method in AdmindashboardComponent
    this.service.showValueChanged.emit(3);
  }
}
