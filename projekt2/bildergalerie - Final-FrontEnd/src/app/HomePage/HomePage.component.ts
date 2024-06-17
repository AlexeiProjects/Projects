import { Component, HostListener, Inject, OnDestroy, OnInit } from '@angular/core';
import { Renderer2 } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ImageInterface } from '../Models/ImageInterface';

@Component({
  selector: 'app-HomePage',
  templateUrl: './HomePage.component.html',
  styleUrls: ['./HomePage.component.css']
})
export class HomePageComponent implements OnInit  {
  

  constructor(private http: HttpClient) { }

  ngOnInit() {


  }

}
