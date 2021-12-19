import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Order } from 'src/app/order';
import { OrderserviceService } from '../orderservice.service';

@Component({
  selector: 'app-getorderbyid',
  templateUrl: './getorderbyid.component.html',
  styleUrls: ['./getorderbyid.component.css']
})
export class GetorderbyidComponent implements OnInit {
  id: any;
  order: any;
  constructor(private route: ActivatedRoute, private oservice:OrderserviceService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.order = new Order();
    this.oservice.getorderById(this.id).subscribe( data => {
      this.order = data;
    });
  }

}
