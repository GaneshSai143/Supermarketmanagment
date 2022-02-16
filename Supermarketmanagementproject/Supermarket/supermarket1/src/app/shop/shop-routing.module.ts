import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrdersComponent } from './orders/orders.component';
import { OutletnameComponent } from './outletname/outletname.component';
import { ShopdetailsComponent } from './shopdetails/shopdetails.component';

const routes: Routes = [
  {path:'shopdetails',component:ShopdetailsComponent},
  {path:'outletname',component:OutletnameComponent},
  {path:'orders',component:OrdersComponent},
  {path:'',redirectTo:'shopdetails',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ShopRoutingModule { }
