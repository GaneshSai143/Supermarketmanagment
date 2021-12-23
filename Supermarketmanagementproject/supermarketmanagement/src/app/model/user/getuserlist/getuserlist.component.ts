import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserserviceService } from 'src/app/login/Service/userservice.service';
import { User } from 'src/app/model/user';

@Component({
  selector: 'app-getuserlist',
  templateUrl: './getuserlist.component.html',
  styleUrls: ['./getuserlist.component.css']
})
export class GetuserlistComponent implements OnInit {

  users:User[]=[];
  
  constructor(private userservice:UserserviceService,private router:Router) { }

  ngOnInit(): void {
    this.getusers();
   // this.createuser();
  }
  private getusers(){
    this.userservice.getusersList().subscribe(data => {this.users=data;});
  }

  updateuser(id:number){
    this.router.navigate(['updateuser',id]);
  }
  deleteuser(id:number){
    this.userservice.deleteuser(id).subscribe(data =>{
      console.log(data);
      this.getusers();
    })
  }

  userDetails(id:number){
    this.router.navigate(['getuserbyid',id]);
  }
 // createuser(){
 //   this.router.navigate(['user/createuser']);
 // }


}
