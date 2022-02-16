import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from '../order';
import { OrderserviceService } from '../orderservice.service';

@Component({
  selector: 'app-orderbyid',
  templateUrl: './orderbyid.component.html',
  styleUrls: ['./orderbyid.component.css']
})
export class OrderbyidComponent implements OnInit {
  id:any;
  order:any;

  constructor(private oService:OrderserviceService,private router:Router,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.order = new Order();
    this.oService.getorderById(this.id).subscribe( data => {
      this.order = data;
    });
  }
  goback(){
    this.router.navigate(['/orders/orderlist'])
  }
}
