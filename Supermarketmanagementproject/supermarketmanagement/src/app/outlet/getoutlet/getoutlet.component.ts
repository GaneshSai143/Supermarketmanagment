import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OutletserviceService } from 'src/app/login/Service/outletservice.service';
import { Outlet } from 'src/app/model/outlet';

@Component({
  selector: 'app-getoutlet',
  templateUrl: './getoutlet.component.html',
  styleUrls: ['./getoutlet.component.css']
})
export class GetoutletComponent implements OnInit {
outlets:Outlet[]=[];
  constructor(private outletservice:OutletserviceService,private router:Router) { }

  ngOnInit(): void {
    this.getoutlets();
  }
  private getoutlets(){
    this.outletservice.getoutletList().subscribe(data => {this.outlets=data;});
  }

  updateoutlet(id:number){
    this.router.navigate(['updateoutlet',id]);
  }
  deleteoutlet(id:number){
    this.outletservice.deleteoutlet(id).subscribe(data =>{
      console.log(data);
      this.getoutlets();
    })
  }

  outletDetails(id:number){
    this.router.navigate(['getoutletbyid',id]);
  }
}
