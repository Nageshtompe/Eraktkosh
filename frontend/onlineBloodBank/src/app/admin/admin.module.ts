import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RequestsofbloodComponent } from './requestsofblood/requestsofblood.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ActionFormComponent } from './action-form/action-form.component';



@NgModule({
  declarations: [
    RequestsofbloodComponent,
    ActionFormComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule
  ],
  exports:[
    RequestsofbloodComponent,
    ActionFormComponent
  ]
})
export class AdminModule { }
