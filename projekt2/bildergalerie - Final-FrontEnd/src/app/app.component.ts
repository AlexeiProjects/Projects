import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HomePageModule } from './HomePage/HomePage.module';
import { HttpClientModule } from '@angular/common/http';
import { UserPageModule } from './UserPage/UserPage.module';
import { UploadPageModule } from './UploadPage/UploadPage.module';




@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,
    HomePageModule,
    HttpClientModule,
    UserPageModule,
    UploadPageModule,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'bildergalerie';
}
