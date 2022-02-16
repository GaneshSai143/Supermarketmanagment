import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Outlets } from '../outlets';
import { OutletserviceService } from '../outletservice.service';

@Component({
  selector: 'app-outletbyid',
  templateUrl: './outletbyid.component.html',
  styleUrls: ['./outletbyid.component.css']
})
export class OutletbyidComponent implements OnInit {
  id:any;
  outlet:any=new Outlets();
user:any=this.outlet.userdto;

  constructor(private oService:OutletserviceService,private router:Router,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

   // this.outlet = new Outlets();
    this.oService.getoutletById(this.id).subscribe( data => {
      this.outlet = data;
    });
  }
  goback(){
    this.router.navigate(['/outlet/outletlist'])
  }

}



