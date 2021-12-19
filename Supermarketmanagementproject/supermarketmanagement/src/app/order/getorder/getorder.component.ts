import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from 'src/app/order';
import { OrderserviceService } from '../orderservice.service';

@Component({
  selector: 'app-getorder',
  templateUrl: './getorder.component.html',
  styleUrls: ['./getorder.component.css']
})
export class GetorderComponent implements OnInit {
  orders:Order[]=[];
  constructor(private oservice:OrderserviceService,private router:Router) { }

  ngOnInit(): void {
    this.getorders();
  }
  private getorders(){
    this.oservice.getorderList().subscribe(data => {this.orders=data;});
  }

  updateorder(id:number){
    this.router.navigate(['updateorder',id]);
  }
  deleteorder(id:number){
    this.oservice.deleteproduct(id).subscribe(data =>{
      console.log(data);
      this.getorders();
    })
  }

  orderDetails(id:number){
    this.router.navigate(['getorderbyid',id]);
  }
  productupdatesendemail(id:number){
    this.router.navigate(['updateproductsendmail',id]);
  }

}
