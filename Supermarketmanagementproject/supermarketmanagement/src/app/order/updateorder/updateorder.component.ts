import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from 'src/app/order';
import { OrderserviceService } from '../orderservice.service';

@Component({
  selector: 'app-updateorder',
  templateUrl: './updateorder.component.html',
  styleUrls: ['./updateorder.component.css']
})
export class UpdateorderComponent implements OnInit {
  order:Order=new Order();
  id:any;
 constructor(private oservice:OrderserviceService,private routerActive:ActivatedRoute,
   private router:Router) { }

 ngOnInit(): void {
   this.id=this.routerActive.snapshot.params['id'];
   this.oservice.getorderById(this.id).subscribe(data =>{
     this.order=data;
   },
   error =>console.log(error)
   );

 }
 onSubmit(){
   this.oservice.updateproduct(this.id,this.order).subscribe(
     data =>{
       console.log(data);
       this.goToorder();
     },
     error => console.log(error)
   )
 }

 goToorder(){
   this.router.navigate(['/getorder']);
 }
}
