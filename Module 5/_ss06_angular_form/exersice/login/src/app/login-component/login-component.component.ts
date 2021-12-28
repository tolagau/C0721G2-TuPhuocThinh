import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {

  constructor() { }
  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required,
      Validators.pattern('^[a-zA-Z0-9_!#$%&\'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-z]{2,6}$')]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)])
  });


  ngOnInit(): void {
  }

  onLogin() {
    console.log(this.loginForm.value);
  }

}
