import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FootterComponent } from './footter/footter.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [
    FootterComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule
  ],
  exports:[
    FootterComponent
  ]
})
export class FooterModule { }
