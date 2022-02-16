import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { Outlets } from '../outlets';
import { OutletserviceService } from '../outletservice.service';

@Component({
  selector: 'app-updateoutlet',
  templateUrl: './updateoutlet.component.html',
  styleUrls: ['./updateoutlet.component.css']
})
export class UpdateoutletComponent implements OnInit {
  outlet:Outlets=new Outlets();
  id:any;
  danger:boolean=false;
  
update:boolean=false;
 constructor(private oService:OutletserviceService,private routerActive:ActivatedRoute,
   private router:Router,private spinner:NgxSpinnerService) { }

 ngOnInit(): void {
   this.id=this.routerActive.snapshot.params['id'];
   this.oService.getoutletById(this.id).subscribe(data =>{
    
     this.outlet=data;
   },
   error =>console.log(error)
   );

 }
 onSubmit(){
   this.spinner.show();
   this.oService.updateoutlet(this.id,this.outlet).subscribe(
     data =>{
       this.update=true;
       console.log(data);
       this.spinner.hide();
       //this.goToCompaniesList();
     },
     error => console.log(this.danger=true)
     //this.danger=true;
   )
 }

 goToOutletsList(){
   this.router.navigate(['/outlet/outletlist']);
 }

 clear(){
   this.update=false;
 }

 goback(){
  this.router.navigate(['/outlet/outletlist']);
 }


}
