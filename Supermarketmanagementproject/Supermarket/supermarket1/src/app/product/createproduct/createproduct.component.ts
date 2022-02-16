import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { Products } from '../products';
import { ProductserviceService } from '../productservice.service';

@Component({
  selector: 'app-createproduct',
  templateUrl: './createproduct.component.html',
  styleUrls: ['./createproduct.component.css']
})
export class CreateproductComponent implements OnInit {
  product:Products=new Products();
  createForm: any;
 duplicate:boolean=false;
 message:boolean=false;
  danger: boolean=false;

  constructor(private productservice:ProductserviceService,private router:Router,
    private formbuilder:FormBuilder,private spinner:NgxSpinnerService) { 
    
  }
  clear(){
    this.message=false;
  }
  ngOnInit(): void {
  this.createForm=new FormGroup({
    'pname':new FormControl(null,Validators.required),
    'price':new FormControl(null,Validators.required),
    'pcode':new FormControl(null,Validators.required),
    'quantity':new FormControl(null,Validators.required)

  })

  }
  private saveproduct(){
    this.spinner.show();
    this.productservice.createproduct(this.createForm.value).subscribe (data => {
      console.log(data);
      this.message=true;
      this.spinner.hide();
      //this.goToUserList();
    },
    error => {console.log(this.duplicate=true);
      this.danger=true;
      this.spinner.hide();
    }
    );
  }

/*  goToproductlist(){
    this.router.navigate(['user/getuserlist'])
  }*/

  onSubmit(){
    console.log(this.product)
    this.saveproduct();

  }

  
get pname() {
  return this.createForm.get('pname');
}
get price() {
  return this.createForm.get('price');
}
get quantity()
{
  return this.createForm.get('quantity');
}
get pcode() {
  return this.createForm.get('pcode');
}

reset(){
  this.duplicate=false;
}

}
