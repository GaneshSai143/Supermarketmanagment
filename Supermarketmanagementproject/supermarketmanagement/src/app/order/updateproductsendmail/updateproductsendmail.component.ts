import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Order } from 'src/app/order';
import { OrderserviceService } from '../orderservice.service';

@Component({
  selector: 'app-updateproductsendmail',
  templateUrl: './updateproductsendmail.component.html',
  styleUrls: ['./updateproductsendmail.component.css']
})
export class UpdateproductsendmailComponent implements OnInit {
  id: any;
  order: any;
  constructor(private route: ActivatedRoute, private oservice:OrderserviceService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.order = new Order();
    this.oservice.productupdatesend(this.id).subscribe( data => {
      this.order = data;
    });

}
}
