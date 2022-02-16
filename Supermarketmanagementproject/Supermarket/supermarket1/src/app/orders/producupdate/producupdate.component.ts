import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from '../order';
import { OrderserviceService } from '../orderservice.service';

@Component({
  selector: 'app-producupdate',
  templateUrl: './producupdate.component.html',
  styleUrls: ['./producupdate.component.css']
})
export class ProducupdateComponent implements OnInit {
  id: any;
  order: any;
  constructor(private route: ActivatedRoute, private oservice:OrderserviceService,private router:Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.order = new Order();
    this.oservice.productupdatesend(this.id).subscribe( data => {
      this.order = data;
    });

}
goback()
{
  this.router.navigate(['orders/orderlist']);
}

}
