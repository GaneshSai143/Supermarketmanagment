import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from 'src/app/orders/order';
import { ShopserviceService } from '../shopservice.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  orders:Order[]=[];
  //outlet:Outlets()=new Outlets();

  id:any;
  constructor(private oservice:ShopserviceService,private router:Router) { }

  ngOnInit(): void {

    this.getOrders();
  }
  private getOrders(){
    console.log(this.orders);
    this.oservice.getorders().subscribe(data => {this.orders=data;});
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
