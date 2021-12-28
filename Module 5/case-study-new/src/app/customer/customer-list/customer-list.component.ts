import {Component, OnInit} from '@angular/core';
import {Subscription} from 'rxjs';
import {Customer} from '../../model/customer';
import {CustomerService} from '../../service/customer.service';
import {CustomerTypeService} from '../../service/customer-type.service';
import {CustomerDeleteComponent} from '../customer-delete/customer-delete.component';
import {MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  private subscription: Subscription;
  customer: Customer | undefined;
  customers: Customer[] | undefined;
  page: 1;
  term: any;

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private dialog: MatDialog) {
  }

  ngOnInit(): void {

    this.subscription = this.customerService.getAllCustomer().subscribe(data => {
        this.customers = data;
      }
      , error => {
        console.log(this.customers);
      });
  }

  openDialog(id): void {
    console.log(id);
    // Trả về đối tượng customer
    this.customerService.findCustomerById(id).subscribe(customerData => {
      console.log(customerData);
      const dialogRef = this.dialog.open(CustomerDeleteComponent, {
        width: '500px',
        data: {customerData},
        // Khi bấm ra ngoài dialog khong bi mat di
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }
}
