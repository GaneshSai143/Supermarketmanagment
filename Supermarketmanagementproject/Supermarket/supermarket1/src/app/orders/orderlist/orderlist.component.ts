import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from '../order';
import { OrderserviceService } from '../orderservice.service';

@Component({
  selector: 'app-orderlist',
  templateUrl: './orderlist.component.html',
  styleUrls: ['./orderlist.component.css']
})
export class OrderlistComponent implements OnInit {
  orders:Order[]=[];

  id:any;
  delete:boolean=false;
  constructor(private oservice:OrderserviceService,private router:Router) { }

  ngOnInit(): void {  

    this.getOutlets();

  }
  private getOutlets(){
    this.oservice.getorderList().subscribe(data => {this.orders=data;});
  }
  

  updateorder(id:number){
    this.router.navigate(['orders/updateorder',id]);
  }
  deleteorder(id:number){
    this.oservice.deleteorder(id).subscribe(data =>{
      this.delete=true;
      console.log(data);
      this.getOutlets();
    })
  }
  orderDetails(id:number){
    this.router.navigate(['orders/orderbyid',id]);
  }
  productupdatesendemail(id:number)
  {
    this.router.navigate(['orders/producupdate',id])
  }

  clear(){
    this.delete=false;
  }
  goback()
  {
    this.router.navigate(['customersuccess']);
  }

}
