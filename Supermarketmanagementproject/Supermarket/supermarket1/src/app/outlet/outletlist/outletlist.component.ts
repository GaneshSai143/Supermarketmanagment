import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Outlets } from '../outlets';
import { OutletserviceService } from '../outletservice.service';

@Component({
  selector: 'app-outletlist',
  templateUrl: './outletlist.component.html',
  styleUrls: ['./outletlist.component.css']
})
export class OutletlistComponent implements OnInit {
  outlet:Outlets[]=[];

  id:any;
  delete:boolean=false;
  constructor(private oservice:OutletserviceService,private router:Router) { }

  ngOnInit(): void {  

    this.getOutlets();

  }
  private getOutlets(){
    this.oservice.getoutletList().subscribe(data => {this.outlet=data;});
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
    this.router.navigate(['sucess']);
  }


}
