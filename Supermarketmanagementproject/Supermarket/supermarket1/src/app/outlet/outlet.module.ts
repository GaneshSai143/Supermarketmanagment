import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OutletRoutingModule } from './outlet-routing.module';
import { CreateoutletComponent } from './createoutlet/createoutlet.component';
import { OutletlistComponent } from './outletlist/outletlist.component';
import { OutletbyidComponent } from './outletbyid/outletbyid.component';
import { UpdateoutletComponent } from './updateoutlet/updateoutlet.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { SendemailComponent } from './sendemail/sendemail.component';
import { NgxSpinnerModule } from 'ngx-spinner';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [
    CreateoutletComponent,
    OutletlistComponent,
    OutletbyidComponent,
    UpdateoutletComponent,
    SendemailComponent
  ],
  imports: [
    CommonModule,
    OutletRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgxSpinnerModule,
    NgxPaginationModule
    
  ]
})
export class OutletModule { }
