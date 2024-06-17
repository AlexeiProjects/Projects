import { Injectable, signal } from '@angular/core';
import { UserInterface } from '../Models/UserInterface';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  /*
  UserInterface - logged
  null - unauth
  undefined - initial state
  */
  currentUserSignal = signal<UserInterface|undefined|null>(undefined)


constructor() { }

}
