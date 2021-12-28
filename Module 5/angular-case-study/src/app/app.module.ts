import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {CustomerListComponent} from './customer/customer-list/customer-list.component';
import {CustomerDetailComponent} from './customer/customer-detail/customer-detail.component';
import {CustomerCreateComponent} from './customer/customer-create/customer-create.component';
import {CustomerDeleteComponent} from './customer/customer-delete/customer-delete.component';
import {CustomerEditComponent} from './customer/customer-edit/customer-edit.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {CustomerModule} from './customer/customer.module';

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    // CustomerDetailComponent,
    // CustomerCreateComponent,
    // CustomerDeleteComponent,
    // CustomerEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    CustomerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
