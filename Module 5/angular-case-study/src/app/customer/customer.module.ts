import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { CustomerCreateComponent } from './customer-create/customer-create.component';
import { CustomerDeleteComponent } from './customer-delete/customer-delete.component';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import { CustomerEditComponent } from './customer-edit/customer-edit.component';

@NgModule({
  declarations: [
    CustomerListComponent,
    CustomerCreateComponent,
    CustomerDeleteComponent,
    CustomerDetailComponent,
    CustomerEditComponent
  ],
  exports: [
    CustomerListComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class CustomerModule {
}
