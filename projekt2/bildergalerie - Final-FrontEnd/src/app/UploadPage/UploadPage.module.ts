import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UploadPageComponent } from './UploadPage.component';
import { SharedModule } from '../Shared/Shared.module';
import {MatIconModule} from '@angular/material/icon';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    MatIconModule
  ],
  declarations: [UploadPageComponent],
  exports:[
    UploadPageComponent
  ]
})
export class UploadPageModule { }
