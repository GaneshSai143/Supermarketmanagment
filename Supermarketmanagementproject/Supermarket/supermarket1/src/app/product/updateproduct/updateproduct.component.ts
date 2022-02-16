import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { Products } from '../products';
import { ProductserviceService } from '../productservice.service';

@Component({
  selector: 'app-updateproduct',
  templateUrl: './updateproduct.component.html',
  styleUrls: ['./updateproduct.component.css']
})
export class UpdateproductComponent implements OnInit {
  product:Products=new Products();
  id:any;
  update:boolean=false;
 constructor(private pservice:ProductserviceService,private routerActive:ActivatedRoute,
   private router:Router,private spinner:NgxSpinnerService) { }

 ngOnInit(): void {
   this.id=this.routerActive.snapshot.params['id'];
   this.pservice.getproductById(this.id).subscribe(data =>{
     this.product=data;
   },
   error =>console.log(error)
   );

 }
 onSubmit(){
   this.spinner.show();
   this.pservice.updateproduct(this.id,this.product).subscribe(
     data =>{
       console.log(data);
       this.update=true;
       this.spinner.hide();
      // this.goTouserList();
     },
     error => console.log(error)
   )
 }

 goTouserList(){
  this.update=true;
   this.router.navigate(['/getuserlist']);
  // this.update=true;
 }
 clear()
 {
   this.update=true;
 }
 goback()
 {
   this.router.navigate(['product/productlist']);
 }
}
