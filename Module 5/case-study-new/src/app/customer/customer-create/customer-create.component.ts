import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Subscription} from 'rxjs';
import {CustomerType} from '../../model/customer-type';
import {Customer} from '../../model/customer';
import {CustomerService} from '../../service/customer.service';
import {Router} from '@angular/router';
import {CustomerTypeService} from '../../service/customer-type.service';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  customerForm = new FormGroup({
    name: new FormControl('', [Validators.required]),
    customer_type: new FormControl(),
    birthday: new FormControl('', [Validators.required]),
    gender: new FormControl(),
    id_card: new FormControl('', [Validators.required, Validators.pattern('^\\d{9}|\\d{12}$')]),
    phone: new FormControl('', [Validators.required,
      Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')]),
    email: new FormControl('', [Validators.required,
      Validators.pattern('^[a-zA-Z0-9_!#$%&\'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-z]{2,6}$')]),
    address: new FormControl('', [Validators.required])
  });
  subscription: Subscription;
  customerTypes: CustomerType[];
  customer: Customer;

  constructor(private customerService: CustomerService,
              private router: Router,
              private customerTypeService: CustomerTypeService) {
  }

  ngOnInit(): void {
    this.subscription = this.customerTypeService.getAllCustomerType().subscribe(data => {
      this.customerTypes = data;
    }, error => {
    });

    if (this.customerForm.valid) {
      this.subscription = this.customerService.saveCustomer(this.customerForm.value).subscribe(data => {
        this.customer = data;
        console.log(this.customer);
      }, error => {
      });
    }

  }

  get name() {
    return this.customerForm.get('name');
  }

  get customer_type() {
    return this.customerForm.get('customer_type');
  }

  get gender() {
    return this.customerForm.get('gender');
  }

  get birthday() {
    return this.customerForm.get('birthday');
  }

  get id_card() {
    return this.customerForm.get('id_card');
  }

  get phone() {
    return this.customerForm.get('phone');
  }

  get address() {
    return this.customerForm.get('address');
  }

  get email() {
    return this.customerForm.get('email');
  }

  onSubmit() {
    console.log(this.customerForm.value.customer_type);
    if (this.customerForm.valid) {
      this.customerTypes.forEach(value => {
        console.log(value);
        if (this.customerForm.value.customer_type == value.id) {
          this.customerForm.value.customer_type = value;
        }
      });
      console.log(this.customerForm.value);
      this.subscription = this.customerService.saveCustomer(this.customerForm.value).subscribe(data => {
          // console.log(this.customer);
          alert('Tạo mới thành công');
          this.router.navigate(['/customer']);
        }
        , error => {
          console.log('Not found');
        });
    }
  }
}
