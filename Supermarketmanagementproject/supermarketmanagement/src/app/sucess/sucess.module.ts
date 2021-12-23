import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SucessRoutingModule } from './sucess-routing.module';
import { AdminComponent } from './admin/admin.component';
import { OutletadminComponent } from './outletadmin/outletadmin.component';
import { CustomerComponent } from './customer/customer.component';


@NgModule({
  declarations: [
    AdminComponent,
    OutletadminComponent,
    CustomerComponent
  ],
  imports: [
    CommonModule,
    SucessRoutingModule
  ]
})
export class SucessModule { }
