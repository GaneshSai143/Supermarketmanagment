import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { OutletserviceService } from 'src/app/login/Service/outletservice.service';
import { Outlet } from 'src/app/model/outlet';
import { User } from 'src/app/model/user';

@Component({
  selector: 'app-createoutlet',
  templateUrl: './createoutlet.component.html',
  styleUrls: ['./createoutlet.component.css']
})
export class CreateoutletComponent implements OnInit {
outlet:Outlet=new Outlet();
user:User=new User();

  constructor(private outletservice:OutletserviceService,private router:Router,private route: ActivatedRoute) { }

  ngOnInit(): void {
  }
  private saveoutlet(){
    this.outletservice.createuseroutlet(this.outlet,this.user).subscribe (data => {
      console.log(data);
      this.goTooutletList();
    },
    error => console.log(error)
    );
  }

  goTooutletList(){
    this.router.navigate(['/getoutlet'])
  }

  onSubmit(){
    console.log(this.outlet)
    this.saveoutlet();
   
  }


}
