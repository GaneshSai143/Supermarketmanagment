import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Outlets } from '../outlets';
import { OutletserviceService } from '../outletservice.service';

@Component({
  selector: 'app-sendemail',
  templateUrl: './sendemail.component.html',
  styleUrls: ['./sendemail.component.css']
})
export class SendemailComponent implements OnInit {
  id: any;
  outlet: any;
  constructor(private route: ActivatedRoute, private oservice:OutletserviceService,private router:Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.outlet = new Outlets();
    this.oservice.productsendemail(this.id).subscribe( data => {
      this.outlet = data;
    });

}
goback()
{
  this.router.navigate(['outlet/outletlist']);
}

}
