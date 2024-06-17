import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-SignUpForm',
  imports: [CommonModule,
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './SignUpForm.component.html',
  styleUrls: ['./SignUpForm.component.css'],
  standalone: true,
})
export class SignUpFormComponent implements OnInit {

  signUpForm = this.fb.group({
    username: ["", Validators.required],
    password: ["", Validators.required],
  });

  isSubmitted = false

  registerSuccess = false

  registerFail = false

  usernameFail: string = ""

  activationClass = '';

  constructor(private fb: FormBuilder, private http: HttpClient) { }

  ngOnInit() {
  }

  moveSignUp() {
    this.activationClass = this.activationClass === 'active' ? '' : 'active'
  }


  onSubmit() {
    this.isSubmitted = true


    // Post Register request on Backend (Spring)
    if (this.signUpForm.valid) {
      this.http.post("http://localhost:8080/auth/register", this.signUpForm.getRawValue())
        .subscribe({
          next: (res: any) => {
            console.log(res)
            if (res.userId == -1) {
              this.registerFail = true;
              this.registerSuccess = false;
              this.usernameFail = res.username;
            } else {
              this.registerSuccess = true;
              this.registerFail = false;
            }
          },
          error: (err) => {
            console.log(err)
          }
        });
    }
    return

  }


}
