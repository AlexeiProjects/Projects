import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit, inject, } from '@angular/core';
import { FormBuilder, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { UserInterface } from '../../Models/UserInterface';
import { response } from 'express';
import { Router } from '@angular/router';
import { AuthService } from '../../servies/auth.service';

@Component({
  selector: 'app-LoginForm',
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './LoginForm.component.html',
  styleUrls: ['./LoginForm.component.css'],
  standalone: true,
})
export class LoginFormComponent implements OnInit {

  loginForm = this.fb.group({
    username: ["", [Validators.required, Validators.minLength(1)]],
    password: ["", Validators.required],
  });

  isSubmitted = false

  activationClass = '';
  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router) { }

  ngOnInit() {

  }

  moveLogin() {
    this.activationClass = this.activationClass === 'active' ? '' : 'active'
  }

  authService = inject(AuthService)

  onSubmit() {
    this.isSubmitted = true

    // Post Login request on Backend (Spring)
    if (this.loginForm.valid) {
      this.http.post<UserInterface>("http://localhost:8080/auth/login", this.loginForm.getRawValue())
        .subscribe({
          next: (res) => {
            console.log(res)
            const user: UserInterface = {
              userId: res.userId,
              username: res.username,
              jwt: res.jwt
            };
            // Save jwt 
            localStorage.setItem("token", user.jwt)
            this.authService.currentUserSignal.set(user)
            this.router.navigateByUrl("/userpage")
          },
          error: (err) => { console.log(err) }
        });
    }
    return
  }



}
