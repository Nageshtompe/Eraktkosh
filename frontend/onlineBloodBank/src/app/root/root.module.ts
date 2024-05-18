import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RootdashboardComponent } from './rootdashboard/rootdashboard.component';
import { LoginModule } from '../login/login.module';



@NgModule({
  declarations: [
    RootdashboardComponent
  ],
  imports: [
    CommonModule,
    LoginModule

  ],
  exports:[
    RootdashboardComponent
  ]
})
export class RootModule { }
