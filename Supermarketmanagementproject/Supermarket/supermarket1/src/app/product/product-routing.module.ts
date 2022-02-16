import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateproductComponent } from './createproduct/createproduct.component';
import { ProductlistComponent } from './productlist/productlist.component';
import { ProuctbyidComponent } from './prouctbyid/prouctbyid.component';
import { UpdateproductComponent } from './updateproduct/updateproduct.component';

const routes: Routes = [

  {path:'productlist',component:ProductlistComponent},
  {path:'createproduct',component:CreateproductComponent},
  {path:'updateproduct/:id',  component:UpdateproductComponent},
  {path: 'productbyid/:id', component:ProuctbyidComponent},
  {path:'',redirectTo:'productlist',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule { }
