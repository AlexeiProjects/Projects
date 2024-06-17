import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedComponent } from './Shared.component';
import { NavbarComponent } from './components/navbar/navbar.component';


@NgModule({
  imports: [
    CommonModule,
    
  ],
  declarations: [SharedComponent,
    NavbarComponent
  ],
  exports:[
    NavbarComponent
  ]
})
export class SharedModule { }
