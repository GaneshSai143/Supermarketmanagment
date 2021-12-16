import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OutletRoutingModule } from './outlet-routing.module';
import { CreateoutletComponent } from './createoutlet/createoutlet.component';
import { UpdateoutletComponent } from './updateoutlet/updateoutlet.component';
import { DeleteoutletComponent } from './deleteoutlet/deleteoutlet.component';
import { GetoutletbyidComponent } from './getoutletbyid/getoutletbyid.component';
import { GetoutletComponent } from './getoutlet/getoutlet.component';


@NgModule({
  declarations: [
    CreateoutletComponent,
    UpdateoutletComponent,
    DeleteoutletComponent,
    GetoutletbyidComponent,
    GetoutletComponent
  ],
  imports: [
    CommonModule,
    OutletRoutingModule
  ]
})
export class OutletModule { }
