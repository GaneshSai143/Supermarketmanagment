import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { ProductserviceService } from 'src/app/product/productservice.service';
import { User } from 'src/app/user';
import { Outlets } from '../outlets';
import { OutletserviceService } from '../outletservice.service';

@Component({
  selector: 'app-createoutlet',
  templateUrl: './createoutlet.component.html',
  styleUrls: ['./createoutlet.component.css']
})
export class CreateoutletComponent implements OnInit {
  productData:any[]=[]
  outlet:Outlets=new Outlets();
  userdto:User = this.outlet.userdto;
 duplicate:boolean=false;
 emailduplicate:boolean=false;
 createForm:boolean=false;
 danger:boolean=false;
 isLoadingResults = false;
isok:boolean=true;


    constructor(private outletservice:OutletserviceService,
      private pservice:ProductserviceService,private fb:FormBuilder,
      private router:Router,private route: ActivatedRoute,private spinner:NgxSpinnerService) { 
      
  
      }
       products(){
        this.pservice.getproductList().subscribe(data=>
          {this.productData=data;
            console.log(this.productData)
          })
    }
    

  
    ngOnInit(): void {
      this.products();
    }
    private saveoutlet(){
      this.spinner.show();
      this.isLoadingResults=false;
      this.outletservice.createuseroutlet(this.outlet).subscribe (data => {
        console.log(data);
        this.createForm=true;
        this.isLoadingResults=true;
        //this.spinner.hide();
       // this.goTooutletList();
      },
     error=>{ console.log(this.duplicate=true);
      this.danger=true;
      this.spinner.hide();
     }
      );
    }
  
    goTooutletList(){
      this.router.navigate(['outlet/getoutlet'])
    }
  
    onSubmit(){
      this.outlet.pcode=this.productData.filter(x=>x.isselected===true).map(x=>x.pcode)
      console.log(this.outlet)
      this.saveoutlet();
     
    }
    clear(){
      this.emailduplicate=false;
      this.duplicate=false;
      this.createForm=false;
      this.danger=false;
    }
    onChange()
    {
this.isok=false;
console.log(this.productData);
    }
   
    
    // reset(){
    //   this.duplicate=false;
    // }
    goback()
    {
    this.router.navigate(['outlet/outletlist'])
    }
}
