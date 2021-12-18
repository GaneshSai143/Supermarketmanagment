import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/model/product';
import { ProductserviceService } from '../productservice.service';

@Component({
  selector: 'app-upateproduct',
  templateUrl: './upateproduct.component.html',
  styleUrls: ['./upateproduct.component.css']
})
export class UpateproductComponent implements OnInit {
  product:Product=new Product();
  id:any;
 constructor(private pservice:ProductserviceService,private routerActive:ActivatedRoute,
   private router:Router) { }

 ngOnInit(): void {
   this.id=this.routerActive.snapshot.params['id'];
   this.pservice.getproductById(this.id).subscribe(data =>{
     this.product=data;
   },
   error =>console.log(error)
   );

 }
 onSubmit(){
   this.pservice.updateproduct(this.id,this.product).subscribe(
     data =>{
       console.log(data);
       this.goToproduct();
     },
     error => console.log(error)
   )
 }

 goToproduct(){
   this.router.navigate(['/getproduct']);
 }

}
