import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UserModule } from './model/user/user.module';
import { OrderModule } from './order/order.module';
import { OutletModule } from './outlet/outlet.module';
import { ProductModule } from './product/product.module';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    UserModule,
    OutletModule,
    ProductModule,
    OrderModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
