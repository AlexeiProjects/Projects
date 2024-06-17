import { Component, OnInit, inject } from '@angular/core';
import { AuthService } from '../servies/auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ImageInterface } from '../Models/ImageInterface';

@Component({
  selector: 'app-UserPage',
  templateUrl: './UserPage.component.html',
  styleUrls: ['./UserPage.component.css']
})
export class UserPageComponent implements OnInit {

  auth = inject(AuthService)

  http = inject(HttpClient)
  
  imageListRes: ImageInterface[] = [];

  constructor() { }

  ngOnInit() {
    // Set jwt in Header
    const token = localStorage.getItem("token") ?? "";
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

    // Get all Images request on Backend (Spring)
    this.http.get<ImageInterface[]>("http://localhost:8080/image", {
      headers: headers
    })
      .subscribe({
        next: (res) => { 
          console.log(res) 
          this.imageListRes = res;
        },
        error: (err) => { console.log(err) }
      }
      )
  }
}
