import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Authguard } from './authguard';
import { CustomersuccessComponent } from './customersuccess/customersuccess.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { OutletsuccessComponent } from './outletsuccess/outletsuccess.component';
import { SucessComponent } from './sucess/sucess.component';

const routes: Routes = [
  {
    path:'user',loadChildren:()=>import ('./user/user.module').then(mod=>mod.UserModule)
  },
  {
    path:'product',loadChildren:()=>import ('./product/product.module').then(mod=>mod.ProductModule)
  },
  {
path:'outlet',loadChildren:()=>import ('./outlet/outlet.module').then(mod=>mod.OutletModule)
  },
  {
path:'orders',loadChildren:()=>import('./orders/orders.module').then(mod=>mod.OrdersModule)
  },
  {
   path:'customer',loadChildren:()=>import('./customer/customer.module').then(mod=>mod.CustomerModule)
  },
  {
    path:'shop',loadChildren:()=>import('./shop/shop.module').then(mod=>mod.ShopModule)
   },

  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'sucess', canActivate: [ Authguard ], component: SucessComponent },
  { path: 'outletsuccess', canActivate: [ Authguard ], component:OutletsuccessComponent},
  { path: 'customersuccess', canActivate: [ Authguard ], component:CustomersuccessComponent },
  { path: 'login', component: LoginComponent },
  {path: 'logout' ,component:LogoutComponent},
  { path: '404', component: NotFoundComponent },
  { path: '**', redirectTo: '404' }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
