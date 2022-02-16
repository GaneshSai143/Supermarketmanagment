import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerregisterComponent } from './customerregister/customerregister.component';
import { GetuserbyidComponent } from './getuserbyid/getuserbyid.component';
import { GetuserlistComponent } from './getuserlist/getuserlist.component';
import { UpdateuserComponent } from './updateuser/updateuser.component';

const routes: Routes = [
  
    {path:'getuserlist',component:GetuserlistComponent},
    {path:'customerregister',component:CustomerregisterComponent},
    {path:'updateuser/:id',  component:UpdateuserComponent},
    {path: 'getuserbyid/:id', component:GetuserbyidComponent},
    {path:'',redirectTo:'getuserlist',pathMatch:'full'}
  
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
