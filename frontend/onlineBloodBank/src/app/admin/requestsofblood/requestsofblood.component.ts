import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { window } from 'rxjs';
import { BloodRequestForm } from 'src/app/model/BloodRequestForm';
import { UrlService } from 'src/app/services/url.service';

@Component({
  selector: 'app-requestsofblood',
  templateUrl: './requestsofblood.component.html',
  styleUrls: ['./requestsofblood.component.css']
})
export class RequestsofbloodComponent {

  constructor(private http:HttpClient,public url:UrlService){

  }

  
  countOfPending:number=0;
  countOfAccepted:number=0;
  countOfRejected:number=0;

  baseUrl=this.url.getUrl();
  // baseUrl='http://13.232.198.136:8080/bloodbank06/'
  shows=0; //1- pending    2-rejected    3-accepted
  

  bloodRequest:BloodRequestForm[]=[]    //data of blood requested donor/user


  getAllRequestOfBlood(num:number){
    this.shows=num
    this.http.get(this.baseUrl+'allrequestedBloodData'+num).subscribe(
      (data:any)=>
      {
        if(data!=null)
        {
          
          
          this.bloodRequest=data
        }
        else
        {
          alert("something error");
        }
        
      }
    );

   

  }


  acceptedBloodRequest(request:any,num:number)
  {
    console.log(num);
    console.log(request);
    
    
    
    this.http.get(this.baseUrl+'bloodrequestaccepted'+request.id+'and'+num).subscribe(
      (data:any)=>
      {

        if(data)
        {
          let index=this.bloodRequest.indexOf(request);
          this.bloodRequest.splice(index,1);
        }
        else
        {
          alert("something error");
        }
      }
    );
    
  }

  onMouseOver(event: MouseEvent,num:number): void {
    // Your code to handle the mouseover event

    this.http.get(this.baseUrl+'getCountOfRequest'+num).subscribe(
      (data:any)=>
      {
        if(num==1)
        {
          this.countOfPending=data;
        }
        else if(num==2)
        {
          this.countOfAccepted=data;
        }
        else if(num==3)
        {
          this.countOfRejected=data;
        }
        else
        {
          alert("something error");
        }
          
      }

    );


  }





}
