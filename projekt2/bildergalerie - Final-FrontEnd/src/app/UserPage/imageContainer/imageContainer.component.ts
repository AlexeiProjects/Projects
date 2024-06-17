import { Component, Input, OnInit, SimpleChanges, inject } from '@angular/core';
import { ImageInterface } from '../../Models/ImageInterface';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-imageContainer',
  templateUrl: './imageContainer.component.html',
  styleUrls: ['./imageContainer.component.css'],
  imports: [
    CommonModule
  ],
  standalone: true
})
export class ImageContainerComponent implements OnInit {

  http = inject(HttpClient)

  @Input() imageList: ImageInterface[] = []

  // Image list for keeping the css class
  imageListWithCssClasses: { image: ImageInterface, cssClass: string }[] = [];

  // Possibel image sizes
  classes = ['big', 'tall', 'small'];

  selectedImage: ImageInterface = {
    id: 0,
    name: '',
    type: '',
    imageData: '',
    userId: 0
  };

  showModal = false;

  constructor(private router: Router) {

  }


  // Wandelt die ImageList in eine ImageList mit einer randomCss Class um. 
  // RandomCssClasse bestimmt die Image Size
  ngOnChanges(changes: SimpleChanges) {
    this.imageListWithCssClasses = this.imageList.map(image => ({
      image,
      cssClass: this.getRandomClass()
    }));
  }

  ngOnInit() {
  }

  getRandomClass() {
    const randomIndex = Math.floor(Math.random() * this.classes.length);
    return this.classes[randomIndex];
  }



  openModal(image: ImageInterface) {
    this.selectedImage = image;
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
  }
  
  
  deleteImage() {
      // Set jwt in Header
    const token = localStorage.getItem("token") ?? "";
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

     // Delete Image request on Backend (Spring)
    this.http.delete<ImageInterface[]>(`http://localhost:8080/image/${this.selectedImage.id}`, {
      headers: headers
    })
      .subscribe({
        next: (res) => { 
          window.location.reload();

        },
        error: (err) => { console.log(err) }
      }
      )
  }

}
