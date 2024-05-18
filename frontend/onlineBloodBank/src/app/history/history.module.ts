import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DonorHistoryComponent } from './donor-history/donor-history.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    DonorHistoryComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
  ],
  exports:[
    DonorHistoryComponent
  ]
})
export class HistoryModule { }
