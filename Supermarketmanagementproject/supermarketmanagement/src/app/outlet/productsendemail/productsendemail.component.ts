import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OutletserviceService } from 'src/app/login/Service/outletservice.service';
import { Outlet } from 'src/app/model/outlet';

@Component({
  selector: 'app-productsendemail',
  templateUrl: './productsendemail.component.html',
  styleUrls: ['./productsendemail.component.css']
})
export class ProductsendemailComponent implements OnInit {
  id: any;
  outlet: any;
  constructor(private route: ActivatedRoute, private oservice:OutletserviceService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.outlet = new Outlet();
    this.oservice.productsendemail(this.id).subscribe( data => {
      this.outlet = data;
    });
  }

}
