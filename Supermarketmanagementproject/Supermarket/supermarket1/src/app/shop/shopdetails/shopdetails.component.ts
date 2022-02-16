import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from 'src/app/orders/order';
import { Outlets } from 'src/app/outlet/outlets';
import { Products } from 'src/app/product/products';
import { ShopserviceService } from '../shopservice.service';

@Component({
  selector: 'app-shopdetails',
  templateUrl: './shopdetails.component.html',
  styleUrls: ['./shopdetails.component.css']
})
export class ShopdetailsComponent implements OnInit {
  
  product:Products[]=[];
  //outlet:Outlets()=new Outlets();

  id:any;
  constructor(private oservice:ShopserviceService,private router:Router) { }

  ngOnInit(): void {

    this.getOutlets();
  }
  private getOutlets(){
    this.oservice.getproductList().subscribe(data => {this.product=data;});
  }

  productupdatesendemail(id:number)
  {
    this.router.navigate(['orders/producupdate',id])
  }


  goback()
  {
    this.router.navigate(['outletsuccess']);
  }
}
