import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/model/product';
import { ProductserviceService } from '../productservice.service';

@Component({
  selector: 'app-createproduct',
  templateUrl: './createproduct.component.html',
  styleUrls: ['./createproduct.component.css']
})
export class CreateproductComponent implements OnInit {
  product:Product=new Product();
    constructor(private productservice:ProductserviceService,private router:Router,private route: ActivatedRoute) { }
  
    ngOnInit(): void {
    }
    private saveproduct(){
      this.productservice.createproduct(this.product).subscribe (data => {
        console.log(data);
        this.goToproductList();
      },
      error => console.log(error)
      );
    }
  
    goToproductList(){
      this.router.navigate(['/getproduct'])
    }
  
    onSubmit(){
      console.log(this.product)
      this.saveproduct();
     
    }

}
