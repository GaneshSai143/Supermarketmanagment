import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OrderRoutingModule } from './order-routing.module';
import { CreateorderComponent } from './createorder/createorder.component';
import { GetorderComponent } from './getorder/getorder.component';
import { GetorderbyidComponent } from './getorderbyid/getorderbyid.component';
import { UpdateorderComponent } from './updateorder/updateorder.component';
import { UpdateproductsendmailComponent } from './updateproductsendmail/updateproductsendmail.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    CreateorderComponent,
    GetorderComponent,
    GetorderbyidComponent,
    UpdateorderComponent,
    UpdateproductsendmailComponent
  ],
  imports: [
    CommonModule,
    OrderRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ]
})
export class OrderModule { }
