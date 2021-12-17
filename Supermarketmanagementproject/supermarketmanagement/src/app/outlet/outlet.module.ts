import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OutletRoutingModule } from './outlet-routing.module';
import { GetoutletComponent } from './getoutlet/getoutlet.component';
import { CreateoutletComponent } from './createoutlet/createoutlet.component';
import { UpdateoutletComponent } from './updateoutlet/updateoutlet.component';
import { GetoutletbyidComponent } from './getoutletbyid/getoutletbyid.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    GetoutletComponent,
    CreateoutletComponent,
    UpdateoutletComponent,
    GetoutletbyidComponent
  ],
  imports: [
    CommonModule,
    OutletRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ]
})
export class OutletModule { }
