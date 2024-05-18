import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserloginComponent } from './userlogin/userlogin.component';
import { UserregistrationComponent } from './userregistration/userregistration.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdmindashboardComponent } from '../dashboard/admindashboard/admindashboard.component';
import { DashboardModule } from '../dashboard/dashboard.module';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';



@NgModule({
  declarations: [
    UserloginComponent,
    UserregistrationComponent,
    AdminloginComponent,
   
  ],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    DashboardModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatInputModule,
    MatFormFieldModule
  
  ],
  exports:[
    UserloginComponent,
    UserregistrationComponent,
    AdminloginComponent,
   
  ]
})
export class LoginModule { }
