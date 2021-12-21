import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthguardService } from './authguard.service';
import { LoginComponent } from './login/login.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { SecureComponent } from './secure/secure.component';

const routes: Routes = [

  {
    path:'',redirectTo:'user/getuserslist',pathMatch:'full'},
    {
      path:'user',loadChildren:()=>import ('./model/user/user.module').then(mod=>mod.UserModule)
    },
    {
      path:'',redirectTo:'outlet/getoutlet',pathMatch:'full'},
      {
        path:'outlet',loadChildren:()=>import ('./outlet/outlet.module').then(mod=>mod.OutletModule)
      },
      {
        path:'',redirectTo:'product/getproduct',pathMatch:'full'},
        {
          path:'product',loadChildren:()=>import ('./product/product.module').then(mod=>mod.ProductModule)
        },
        {
          path:'',redirectTo:'order/getorder',pathMatch:'full'},
          {
            path:'order',loadChildren:()=>import ('./order/order.module').then(mod=>mod.OrderModule)
          },

          {path:'login',component:LoginComponent},
          {path:'secure',canActivate:[AuthguardService], component:SecureComponent},
          {path :'404',component:NotfoundComponent},
          { path: '**', redirectTo: '404' }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
