import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit, inject } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  
  http = inject(HttpClient)
  
  constructor(private router: Router) { }

  ngOnInit() {
  }

  onlogout(){
    // Set header with the jwt
    const token = localStorage.getItem("token") ?? "";
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

     // Post Logout request on Backend (Spring)
    this.http.post("http://localhost:8080/logout", {
      headers: headers
    })
      .subscribe({
        next: (res) => { 
          console.log(res)
          // Remove jwt and navigate to HomePage
          localStorage.removeItem('token');
          this.router.navigateByUrl("")

        },
        error: (err) => { console.log(err) }
      }
      )
  }

}
