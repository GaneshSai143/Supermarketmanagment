import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { CustomerlistComponent } from './customerlist/customerlist.component';
import { UpdatecustomerComponent } from './updatecustomer/updatecustomer.component';
import { CustomerbyidComponent } from './customerbyid/customerbyid.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxSpinnerModule } from 'ngx-spinner';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [
    CustomerlistComponent,
    UpdatecustomerComponent,
    CustomerbyidComponent
  ],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgxSpinnerModule,
    NgxPaginationModule
  ]
})
export class CustomerModule { }
