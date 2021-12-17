import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [

  {
    path:'',redirectTo:'user/getuserslist',pathMatch:'full'},
    {
      path:'user',loadChildren:()=>import ('./user/user.module').then(mod=>mod.UserModule)
    },
    {
      path:'',redirectTo:'outlet/getoutlet',pathMatch:'full'},
      {
        path:'outlet',loadChildren:()=>import ('./outlet/outlet.module').then(mod=>mod.OutletModule)
      }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
