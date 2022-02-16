import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShopRoutingModule } from './shop-routing.module';
import { ShopdetailsComponent } from './shopdetails/shopdetails.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { OutletnameComponent } from './outletname/outletname.component';
import { OrdersComponent } from './orders/orders.component';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [
    ShopdetailsComponent,
    OutletnameComponent,
    OrdersComponent
  ],
  imports: [
    CommonModule,
    ShopRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule
  ]
})
export class ShopModule { }
