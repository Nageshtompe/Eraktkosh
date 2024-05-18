import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { UserdashboardComponantModule } from '../userdashboard-componant/userdashboard-componant.module';
import { AdminModule } from '../admin/admin.module';
import { HistoryModule } from '../history/history.module';



@NgModule({
  declarations: [
    UserdashboardComponent,
    AdmindashboardComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    UserdashboardComponantModule,
    HistoryModule,
    AdminModule,

  ],
  exports:[
    UserdashboardComponent,
    AdmindashboardComponent
  ]
  
})
export class DashboardModule { }
