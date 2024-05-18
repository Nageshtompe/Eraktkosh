import { Component } from '@angular/core';

import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'onlineBloodBank';

   

  whatToShow:any=0;
  dashboard=0;
  
  show(num:number){
    console.log(num);
    
    this.whatToShow=num;
  }

 


}
