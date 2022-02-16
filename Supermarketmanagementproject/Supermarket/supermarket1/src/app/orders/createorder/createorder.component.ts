import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { OutletserviceService } from 'src/app/outlet/outletservice.service';
import { ProductserviceService } from 'src/app/product/productservice.service';
import { Order } from '../order';
import { OrderserviceService } from '../orderservice.service';

@Component({
  selector: 'app-createorder',
  templateUrl: './createorder.component.html',
  styleUrls: ['./createorder.component.css']
})
export class CreateorderComponent implements OnInit {
  productData:any[]=[];
  outletdata:any[]=[];
  orders:Order=new Order();
 duplicate:boolean=false;
 emailduplicate:boolean=false;
 createForm:boolean=false;
 danger:boolean=false;
 isLoadingResults = false;
isok:boolean=true;
isok1:boolean=true;


    constructor(private oservice:OutletserviceService,
      private orderservice:OrderserviceService,
      private pservice:ProductserviceService,private fb:FormBuilder,
      private router:Router,private route: ActivatedRoute,private spinner:NgxSpinnerService) { 
      
  
      }
       products(){
        this.orderservice.getproducts().subscribe(data=>
          {this.productData=data;
            console.log(this.productData)
          })
    }
    outlets(){
      this.orderservice.getoutlets().subscribe(data=>
        {this.outletdata=data;
          console.log(this.outletdata)
        })
  }
    

  
    ngOnInit(): void {
      this.products();
      this.outlets();
    }
    private saveoutlet(){
      this.spinner.show();
      this.isLoadingResults=false;
      this.orderservice.createorder(this.orders).subscribe (data => {
        console.log(data);
        this.createForm=true;
        this.isLoadingResults=true;
       // this.spinner.hide();
       // this.goTooutletList();
      },
     error=>{ console.log(this.duplicate=true);
      this.danger=true;
      this.spinner.hide();
     }
      );
    }
  
    goToorderList(){
      this.router.navigate(['orders/orderlist'])
    }
  
    onSubmit(){
      this.orders.pcode=this.productData.filter(x=>x.isselected===true).map(x=>x.pcode)
      console.log(this.orders)
      this.orders.ocode=this.outletdata.filter(x=>x.isselected===true).map(x=>x.ocode)
      console.log(this.orders)
      this.saveoutlet();
     
    }
    clear(){
      this.emailduplicate=false;
      this.duplicate=false;
      this.createForm=false;
      this.danger=false;
    }
    onChange()
    {
this.isok=false;
console.log(this.productData);

    }
    onChange1()
    {
this.isok1=false;
console.log(this.outletdata)
    }
   
    goback()
    {
    this.router.navigate(['orders/orderlist'])
    }
}
