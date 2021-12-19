import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateorderComponent } from './createorder/createorder.component';
import { GetorderComponent } from './getorder/getorder.component';
import { GetorderbyidComponent } from './getorderbyid/getorderbyid.component';
import { UpdateorderComponent } from './updateorder/updateorder.component';
import { UpdateproductsendmailComponent } from './updateproductsendmail/updateproductsendmail.component';

const routes: Routes = [

  {path:'getorder',component:GetorderComponent},
  {path:'createorder',component:CreateorderComponent},
  {path:'updateorder/:id',  component:UpdateorderComponent},
  {path:'updateproductsendmail/:id',  component:UpdateproductsendmailComponent},
  {path: 'getorderbyid/:id', component: GetorderbyidComponent},
  {path:'',redirectTo:'order',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OrderRoutingModule { }
