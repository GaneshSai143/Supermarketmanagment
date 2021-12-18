import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OutletserviceService } from 'src/app/login/Service/outletservice.service';
import { Outlet } from 'src/app/model/outlet';

@Component({
  selector: 'app-getoutletbyid',
  templateUrl: './getoutletbyid.component.html',
  styleUrls: ['./getoutletbyid.component.css']
})
export class GetoutletbyidComponent implements OnInit {

  id: any;
  outlet: any;
  constructor(private route: ActivatedRoute, private oservice: OutletserviceService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.outlet = new Outlet();
    this.oservice.getoutletById(this.id).subscribe( data => {
      this.outlet = data;
    });
  }


}
