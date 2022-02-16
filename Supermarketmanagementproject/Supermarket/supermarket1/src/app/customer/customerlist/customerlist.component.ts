import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/user';
import { CustomerserviceService } from '../customerservice.service';

@Component({
  selector: 'app-customerlist',
  templateUrl: './customerlist.component.html',
  styleUrls: ['./customerlist.component.css']
})
export class CustomerlistComponent implements OnInit {
  users:User[]=[];
  delete:boolean=false;
  dele:boolean=false;
  constructor(private userservice:CustomerserviceService,private router:Router) { }

  ngOnInit(): void {
    this.getusers();
   // this.createuser();
  }
  private getusers(){
    this.userservice.getusersList().subscribe(data => {this.users=data;});
  }

  updateuser(id:number){
    this.router.navigate(['customer/updatecustomer',id]);
  }
  deleteuser(id:number){
    this.userservice.deleteuser(id).subscribe(data =>{
      if(data===null){
        this.delete=false;
        this.dele=true;
      }
      else{
        this.delete=true
      }
      console.log(data);
      this.getusers();
    })
  }
  

  userDetails(id:number){
    this.router.navigate(['customer/customerbyid',id]);
  }
  clear()
  {
    this.delete=false;
  }

  goback()
  {
    this.router.navigate(['customersuccess']);
  }

}
