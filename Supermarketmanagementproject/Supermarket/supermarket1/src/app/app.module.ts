import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { SucessComponent } from './sucess/sucess.component';
import {MatSortModule} from '@angular/material/sort';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatTableModule} from '@angular/material/table';
import {MatIconModule} from '@angular/material/icon';
import { AuthInterceptor } from './auth.intercepter';
import { MatPaginatorModule } from '@angular/material/paginator';
import { UserModule } from './user/user.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import { ProductModule } from './product/product.module';
import { OutletModule } from './outlet/outlet.module';
import { OrdersModule } from './orders/orders.module';
import { NgxSpinnerModule } from 'ngx-spinner';
import { CustomerModule } from './customer/customer.module';
import { OutletsuccessComponent } from './outletsuccess/outletsuccess.component';
import { CustomersuccessComponent } from './customersuccess/customersuccess.component';
import { ShopModule } from './shop/shop.module';
import { NgxPaginationModule } from 'ngx-pagination';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LogoutComponent,
    NotFoundComponent,
    SucessComponent,
    OutletsuccessComponent,
    CustomersuccessComponent
  ],
  imports: [
    BrowserModule,
    UserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatPaginatorModule,
    MatProgressSpinnerModule,
    MatSortModule,
    MatTableModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    ProductModule,
    OutletModule,
    OrdersModule,
    NgxSpinnerModule,
    CustomerModule,
    ShopModule,
    NgxPaginationModule,
    MatInputModule,
    MatIconModule,
    MatSortModule,
    MatTableModule,
    MatPaginatorModule

  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
