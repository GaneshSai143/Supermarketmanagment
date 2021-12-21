import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { Observable } from 'rxjs';
import { OutletserviceService } from 'src/app/login/Service/outletservice.service';
import { Outlet } from 'src/app/model/outlet';
import { Product } from 'src/app/model/product';
import { ProductserviceService } from 'src/app/product/productservice.service';


@Component({
  selector: 'app-createoutlet',
  templateUrl: './createoutlet.component.html',
  styleUrls: ['./createoutlet.component.css']
})
export class CreateoutletComponent implements OnInit {
outlet:Outlet=new Outlet();
private pcode: number[] = new Array<number>();
//pcode: Observable<Product[]>|any;

  constructor(private outletservice:OutletserviceService,
    private pservice:ProductserviceService,
    private router:Router,private route: ActivatedRoute) { }

  ngOnInit(): void {
  }
  private saveoutlet(){
    this.outletservice.createuseroutlet(this.outlet).subscribe (data => {
      console.log(data);
      this.outlet.push(this.pcode);
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
