import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import { CreateproductComponent } from './createproduct/createproduct.component';
import { GetproductComponent } from './getproduct/getproduct.component';
import { GetproductbyidComponent } from './getproductbyid/getproductbyid.component';
import { UpateproductComponent } from './upateproduct/upateproduct.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    CreateproductComponent,
    GetproductComponent,
    GetproductbyidComponent,
    UpateproductComponent
  ],
  imports: [
    CommonModule,
    ProductRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ]
})
export class ProductModule { }
