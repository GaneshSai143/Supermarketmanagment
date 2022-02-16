import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { User } from 'src/app/user';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-updateuser',
  templateUrl: './updateuser.component.html',
  styleUrls: ['./updateuser.component.css']
})
export class UpdateuserComponent implements OnInit {
  user:User=new User();
  id:any;
  update:boolean=false;
 constructor(private userservice:UserserviceService,private routerActive:ActivatedRoute,
   private router:Router,private spinner:NgxSpinnerService) { }

 ngOnInit(): void {
   this.id=this.routerActive.snapshot.params['id'];
   this.userservice.getuserById(this.id).subscribe(data =>{
     this.user=data;
   },
   error =>console.log(error)
   );

 }
 onSubmit(){
   this.spinner.show();
   this.userservice.updateuser(this.id,this.user).subscribe(
     data =>{
       console.log(data);
       this.update=true;
       this.spinner.hide();
      // this.goTouserList();
     },
     error => console.log(error)
   )
 }

 goTouserList(){
  this.update=true;
   this.router.navigate(['/getuserlist']);
  // this.update=true;
 }
 clear()
 {
   this.update=true;
 }

 goback()
 {
   this.router.navigate(['user/getuserlist']);
 }

}
