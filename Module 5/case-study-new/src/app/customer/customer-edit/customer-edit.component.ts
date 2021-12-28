import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CustomerTypeService} from '../../service/customer-type.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Subscription} from 'rxjs';
import {CustomerType} from '../../model/customer-type';
import {Customer} from '../../model/customer';


@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  customerEditForm = new FormGroup({
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
  id: number;
  subscription: Subscription;
  customerTypes: CustomerType[];
  customer: Customer;

  constructor(private customerService: CustomerService,
              private router: Router,
              private customerTypeService: CustomerTypeService,
              private activatedRoute: ActivatedRoute
  ) {

  }

  ngOnInit(): void {
    this.subscription = this.customerTypeService.getAllCustomerType().subscribe(data => {
      this.customerTypes = data;
    }, error => {
    });

    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
    });
    this.subscription = this.customerService.findCustomerById(this.id).subscribe(data => {
      this.customer = data;
      this.customerEditForm.setValue(this.customer);
      console.log(this.customer);
    });
    // end
  }

  get name() {
    return this.customerEditForm.get('name');
  }

  get customer_type() {
    return this.customerEditForm.get('customer_type');
  }

  get gender() {
    return this.customerEditForm.get('gender');
  }

  get birthday() {
    return this.customerEditForm.get('birthday');
  }

  get id_card() {
    return this.customerEditForm.get('id_card');
  }

  get phone() {
    return this.customerEditForm.get('phone');
  }

  get address() {
    return this.customerEditForm.get('address');
  }

  get email() {
    return this.customerEditForm.get('email');
  }

  onSubmit() {
    if (this.customerEditForm.valid) {
      this.subscription = this.customerService.updateCustomer(this.id, this.customerEditForm.value).subscribe(data => {
        alert('Chỉnh sửa thành công');
        this.router.navigate(['/customer']);
      }, error => {
      });
    }
  }
}
