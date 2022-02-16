import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Outlets } from 'src/app/outlet/outlets';
import { OutletserviceService } from 'src/app/outlet/outletservice.service';
import { ShopserviceService } from '../shopservice.service';

@Component({
  selector: 'app-outletname',
  templateUrl: './outletname.component.html',
  styleUrls: ['./outletname.component.css']
})
export class OutletnameComponent implements OnInit {
 
  outlet:Outlets[]=[];

  //outlet=new Outlets();
id:any;
  delete:boolean=false;
  constructor(private sservice:ShopserviceService,
    private oservice:OutletserviceService,
    private router:Router) { }

  ngOnInit(): void {  

    this.getOutlets();

  }
  private getOutlets(){
    
    this.sservice.getoutletname().subscribe(data => {this.outlet=data;});
  }
  

  updateoutlet(id:number){
    this.router.navigate(['outlet/updateoutlet',id]);
  }
  deleteoutlet(id:number){
    this.oservice.deleteoutlet(id).subscribe(data =>{
      this.delete=true;
      console.log(data);
      this.getOutlets();
    })
  }
  OutletDetails(id:number){
    this.router.navigate(['outlet/outletbyid',id]);
  }
  sendemail(id:number){
    this.router.navigate(['outlet/sendemail',id]);
  }

  clear(){
    this.delete=false;
  }
  goback()
  {
    this.router.navigate(['outletsuccess']);
  }
}
