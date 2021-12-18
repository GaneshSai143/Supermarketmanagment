import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/model/product';
import { ProductserviceService } from '../productservice.service';

@Component({
  selector: 'app-getproduct',
  templateUrl: './getproduct.component.html',
  styleUrls: ['./getproduct.component.css']
})
export class GetproductComponent implements OnInit {
  products:Product[]=[];
  constructor(private productservice:ProductserviceService,private router:Router) { }

  ngOnInit(): void {
    this.getproducts();
  }
  private getproducts(){
    this.productservice.getproductList().subscribe(data => {this.products=data;});
  }

  updateproduct(id:number){
    this.router.navigate(['updateproduct',id]);
  }
  deleteproduct(id:number){
    this.productservice.deleteproduct(id).subscribe(data =>{
      console.log(data);
      this.getproducts();
    })
  }

  productDetails(id:number){
    this.router.navigate(['getproductbyid',id]);
  }
}
