import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-UploadPage',
  templateUrl: './UploadPage.component.html',
  styleUrls: ['./UploadPage.component.css']
})
export class UploadPageComponent implements OnInit {

  imageUrl: string | ArrayBuffer | null = null;
  imageFile: File | null = null;
  
  uploadSucces = false;
  uploadFail = false;

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  // Show Selected Image
  onSelectedImage(event: any) {
    const file = event.target.files[0];
    if (file) {

      this.uploadSucces = false;
      this.uploadFail = false;
      
      this.imageFile = file;

      const reader = new FileReader();
      reader.onload = () => {
        this.imageUrl = reader.result;
      };
      reader.readAsDataURL(file);
    }
  }

  // Upload Image
  UploadImage() {
    if (this.imageFile) {

      const formData = new FormData();
      formData.append("file", this.imageFile)

      // Set jwt in Header
      const token = localStorage.getItem("token") ?? "";
      const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

      // Post Upload request on Backend (Spring)
      this.http.post("http://localhost:8080/image", formData, {
        headers: headers
      })
        .subscribe({
          next: (res) => { 
            console.log(res) 
            this.uploadSucces = true},
          error: (err) => { 
            console.log(err) 
            this.uploadSucces = true
          }
        }
        )

    }
    else {
      alert("no Image selected")
    }
  }


}
