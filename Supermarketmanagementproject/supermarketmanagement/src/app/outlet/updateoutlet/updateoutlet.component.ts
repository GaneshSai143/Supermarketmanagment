import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OutletserviceService } from 'src/app/login/Service/outletservice.service';
import { Outlet } from 'src/app/model/outlet';

@Component({
  selector: 'app-updateoutlet',
  templateUrl: './updateoutlet.component.html',
  styleUrls: ['./updateoutlet.component.css']
})
export class UpdateoutletComponent implements OnInit {
  outlet:Outlet=new Outlet();
  id:any;
 constructor(private oservice:OutletserviceService,private routerActive:ActivatedRoute,
   private router:Router) { }

 ngOnInit(): void {
   this.id=this.routerActive.snapshot.params['id'];
   this.oservice.getoutletById(this.id).subscribe(data =>{
     this.outlet=data;
   },
   error =>console.log(error)
   );

 }
 onSubmit(){
   this.oservice.updateoutlet(this.id,this.outlet).subscribe(
     data =>{
       console.log(data);
       this.goToOutlet();
     },
     error => console.log(error)
   )
 }

 goToOutlet(){
   this.router.navigate(['/getoutlet']);
 }

}
