import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Products } from '../products';
import { ProductserviceService } from '../productservice.service';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {
  product:Products[]=[];
  delete:boolean=false;
  dele:boolean=false;
  constructor(private pservice:ProductserviceService,private router:Router) { }

  ngOnInit(): void {
    this.getproducts();
   // this.createuser();
  }
  private getproducts(){
    this.pservice.getproductList().subscribe(data => {this.product=data;});
  }

  updateproduct(id:number){
    this.router.navigate(['product/updateproduct',id]);
  }
  deleteproduct(id:number){
    this.pservice.deleteproduct(id).subscribe(data =>{
      console.log(data);
      this.delete=true;
      this.getproducts();
    })
  }

  productDetails(id:number){
    this.router.navigate(['product/productbyid',id]);
  }
  clear()
  {
    this.delete=false;
  }
  goback()
  {
    this.router.navigate(['sucess']);
  }

}
