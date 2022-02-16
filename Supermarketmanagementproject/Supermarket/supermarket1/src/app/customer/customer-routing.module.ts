import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerbyidComponent } from './customerbyid/customerbyid.component';
import { CustomerlistComponent } from './customerlist/customerlist.component';
import { UpdatecustomerComponent } from './updatecustomer/updatecustomer.component';

const routes: Routes = [
  {path:'customerlist',component:CustomerlistComponent},
    {path:'updatecustomer/:id',  component:UpdatecustomerComponent},
    {path: 'customerbyid/:id', component:CustomerbyidComponent},
    {path:'',redirectTo:'customerlist',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
