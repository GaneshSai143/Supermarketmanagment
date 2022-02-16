import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OrdersRoutingModule } from './orders-routing.module';
import { CreateorderComponent } from './createorder/createorder.component';
import { OrderlistComponent } from './orderlist/orderlist.component';
import { OrderbyidComponent } from './orderbyid/orderbyid.component';
import { UpdateorderComponent } from './updateorder/updateorder.component';
import { ProducupdateComponent } from './producupdate/producupdate.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxSpinnerModule } from 'ngx-spinner';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [
    CreateorderComponent,
    OrderlistComponent,
    OrderbyidComponent,
    UpdateorderComponent,
    ProducupdateComponent
  ],
  imports: [
    CommonModule,
    OrdersRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgxSpinnerModule,
    NgxPaginationModule
  ]
})
export class OrdersModule { }
