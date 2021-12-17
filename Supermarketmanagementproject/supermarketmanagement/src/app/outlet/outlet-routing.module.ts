import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateoutletComponent } from './createoutlet/createoutlet.component';
import { GetoutletComponent } from './getoutlet/getoutlet.component';
import { GetoutletbyidComponent } from './getoutletbyid/getoutletbyid.component';
import { UpdateoutletComponent } from './updateoutlet/updateoutlet.component';

const routes: Routes = [

  {path:'getoutlet',component:GetoutletComponent},
  {path:'createoutlet',component:CreateoutletComponent},
  {path:'updateoutlet/:id',  component:UpdateoutletComponent},
  {path: 'getoutletbyid/:id', component: GetoutletbyidComponent},
  {path:'',redirectTo:'outlet',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OutletRoutingModule { }
