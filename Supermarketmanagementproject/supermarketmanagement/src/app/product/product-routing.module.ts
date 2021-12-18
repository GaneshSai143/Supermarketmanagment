import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateproductComponent } from './createproduct/createproduct.component';
import { GetproductComponent } from './getproduct/getproduct.component';
import { GetproductbyidComponent } from './getproductbyid/getproductbyid.component';
import { UpateproductComponent } from './upateproduct/upateproduct.component';

const routes: Routes = [
  {path:'getproduct',component:GetproductComponent},
  {path:'createproduct',component:CreateproductComponent},
  {path:'updateproduct/:id',  component:UpateproductComponent},
  {path: 'getproductbyid/:id', component: GetproductbyidComponent},
  {path:'',redirectTo:'outlet',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule { }
