import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { UpdateuserComponent } from './updateuser/updateuser.component';
import { GetuserbyidComponent } from './getuserbyid/getuserbyid.component';
import { GetuserlistComponent } from './getuserlist/getuserlist.component';
import { CustomerregisterComponent } from './customerregister/customerregister.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxSpinnerModule } from 'ngx-spinner';
import { NgxPaginationModule } from 'ngx-pagination';
import { MatIconModule } from '@angular/material/icon';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';

@NgModule({
  declarations: [
    UpdateuserComponent,
    GetuserbyidComponent,
    GetuserlistComponent,
    CustomerregisterComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgxSpinnerModule,
    NgxPaginationModule,
    MatIconModule,
    MatSortModule,
    MatTableModule,
    MatPaginatorModule

  ]
})
export class UserModule { }
