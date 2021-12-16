import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { CreateuserComponent } from './createuser/createuser.component';
import { GetuserbyidComponent } from './getuserbyid/getuserbyid.component';
import { GetuserlistComponent } from './getuserlist/getuserlist.component';
import { UpdateuserComponent } from './updateuser/updateuser.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    CreateuserComponent,
    GetuserbyidComponent,
    GetuserlistComponent,
    UpdateuserComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    FormsModule,HttpClientModule,
    ReactiveFormsModule

  ]
})
export class UserModule { }
