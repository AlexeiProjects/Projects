import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserPageComponent } from './UserPage.component';
import { SharedModule } from '../Shared/Shared.module';
import { ImageContainerComponent } from './imageContainer/imageContainer.component';





@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    ImageContainerComponent
  ],
  declarations: [
    UserPageComponent,
  ],
  exports:[
    UserPageComponent
  ]
})
export class UserPageModule { }
