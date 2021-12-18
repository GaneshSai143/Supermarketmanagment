import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateuserComponent } from './createuser/createuser.component';
import { GetuserbyidComponent } from './getuserbyid/getuserbyid.component';
import { GetuserlistComponent } from './getuserlist/getuserlist.component';
import { UpdateuserComponent } from './updateuser/updateuser.component';

const routes: Routes = [
  {path:'getuserlist',component:GetuserlistComponent},
  {path:'createuser',component:CreateuserComponent},
  {path:'updateuser/:id',  component:UpdateuserComponent},
  {path: 'getuserbyid/:id', component: GetuserbyidComponent},
  {path:'',redirectTo:'user',pathMatch:'full'}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
