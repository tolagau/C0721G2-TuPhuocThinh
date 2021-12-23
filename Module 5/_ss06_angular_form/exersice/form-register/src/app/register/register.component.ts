import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  countryList = [{id: 1, name: 'Viet Nam'}, {id: 2, name: 'USA'}, {id: 3, name: 'Korea'}];
  contactForm = new FormGroup({
    email: new FormControl('', [Validators.required,
      Validators.pattern('^[a-zA-Z0-9_!#$%&\'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-z]{2,6}$')]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    confirmPassword : new FormControl('', [Validators.required, Validators.minLength(6)]),
    country: new FormControl('', [Validators.required]),
    age: new FormControl('', [Validators.required, Validators.min(18)]),
    gender: new FormControl('', [Validators.required]),
    phone: new FormControl('', [Validators.required, Validators.pattern('^\\+84\\d{9,10}$')])
  });
  constructor() { }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.contactForm.value);
  }
}
