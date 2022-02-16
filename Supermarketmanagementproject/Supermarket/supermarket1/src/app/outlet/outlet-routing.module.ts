import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateoutletComponent } from './createoutlet/createoutlet.component';
import { OutletbyidComponent } from './outletbyid/outletbyid.component';
import { OutletlistComponent } from './outletlist/outletlist.component';
import { SendemailComponent } from './sendemail/sendemail.component';
import { UpdateoutletComponent } from './updateoutlet/updateoutlet.component';

const routes: Routes = [
  {path:'outletlist',component:OutletlistComponent},
  {path:'createoutlet',component:CreateoutletComponent},
  {path:'updateoutlet/:id',  component:UpdateoutletComponent},
  {path: 'outletbyid/:id', component:OutletbyidComponent},
  {path:'sendemail/:id',component:SendemailComponent},
  {path:'',redirectTo:'outletlist',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OutletRoutingModule { }
