import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateorderComponent } from './createorder/createorder.component';
import { OrderbyidComponent } from './orderbyid/orderbyid.component';
import { OrderlistComponent } from './orderlist/orderlist.component';
import { ProducupdateComponent } from './producupdate/producupdate.component';
import { UpdateorderComponent } from './updateorder/updateorder.component';

const routes: Routes = [
  {path:'orderlist',component:OrderlistComponent},
  {path:'createorder',component:CreateorderComponent},
  {path:'updateorder/:id',  component:UpdateorderComponent},
  {path: 'orderbyid/:id', component:OrderbyidComponent},
  {path:'producupdate/:id',component:ProducupdateComponent},
  {path:'',redirectTo:'orderlistt',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OrdersRoutingModule { }
