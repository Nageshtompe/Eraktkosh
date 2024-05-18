import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LookingforbloodComponent } from './lookingforblood/lookingforblood.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { WanttodonatebloodComponent } from './wanttodonateblood/wanttodonateblood.component';



@NgModule({
  declarations: [
    LookingforbloodComponent,
    WanttodonatebloodComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    
    
  ],
  exports:[
    LookingforbloodComponent,
    WanttodonatebloodComponent
    
  ],
})
export class UserdashboardComponantModule { }
