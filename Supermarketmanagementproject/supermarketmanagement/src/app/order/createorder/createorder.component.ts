import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from 'src/app/order';
import { OrderserviceService } from '../orderservice.service';

@Component({
  selector: 'app-createorder',
  templateUrl: './createorder.component.html',
  styleUrls: ['./createorder.component.css']
})
export class CreateorderComponent implements OnInit {
  order:Order=new Order();
  constructor(private oservice:OrderserviceService,private router:Router,private route: ActivatedRoute) { }

  ngOnInit(): void {
  }
  private saveorder(){
    this.oservice.createorder(this.order).subscribe (data => {
      console.log(data);
      this.goToorderList();
    },
    error => console.log(error)
    );
  }

  goToorderList(){
    this.router.navigate(['/getorder'])
  }

  onSubmit(){
    console.log(this.order)
    this.saveorder();
   
  }

}
