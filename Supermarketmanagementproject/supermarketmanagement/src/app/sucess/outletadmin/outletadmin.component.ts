import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OutletserviceService } from 'src/app/login/Service/outletservice.service';

@Component({
  selector: 'app-outletadmin',
  templateUrl: './outletadmin.component.html',
  styleUrls: ['./outletadmin.component.css']
})
export class OutletadminComponent implements OnInit {

  constructor(private router:Router,private oservivce:OutletserviceService) { }

  ngOnInit(): void {
  }
onsubmit(){
  this.router.navigate(['/outlet/createoutlet']);
  this.router.navigate(['outlet/getoutlet']);
  this.router.navigate(['/outlet/getoutletbyid']);
}
}
