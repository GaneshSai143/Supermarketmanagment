import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { Order } from '../order';
import { OrderserviceService } from '../orderservice.service';

@Component({
  selector: 'app-updateorder',
  templateUrl: './updateorder.component.html',
  styleUrls: ['./updateorder.component.css']
})
export class UpdateorderComponent implements OnInit {
  order:Order=new Order();
  id:any;
  danger:boolean=false;
  
update:boolean=false;
 constructor(private oService:OrderserviceService,private routerActive:ActivatedRoute,
   private router:Router,private spinner:NgxSpinnerService) { }

 ngOnInit(): void {
   this.id=this.routerActive.snapshot.params['id'];
   this.oService.getorderById(this.id).subscribe(data =>{
    
     this.order=data;
   },
   error =>console.log(error)
   );

 }
 onSubmit(){
   this.spinner.show();
   this.oService.updateorder(this.id,this.order).subscribe(
     data =>{
       this.update=true;
       console.log(data);
       this.spinner.hide();
       //this.goToCompaniesList();
     },
     error => console.log(this.danger=true)
     //this.danger=true;
   )
 }

 goToOutletsList(){
   this.router.navigate(['/orders/orderlist']);
 }

 clear(){
   this.update=false;
 }

 goback(){
  this.router.navigate(['/orders/orderlist']);
 }

}
