import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './HomePage.component';
import { LoginFormComponent } from './LoginForm/LoginForm.component';
import { SignUpFormComponent } from './SignUpForm/SignUpForm.component';
import { FormControl } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    LoginFormComponent,
    SignUpFormComponent,
    
  ],
  declarations: [HomePageComponent],
  exports:[
    HomePageComponent
  ]
})
export class HomePageModule { }
