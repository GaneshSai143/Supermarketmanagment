import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserserviceService } from 'src/app/login/Service/userservice.service';
import { User } from 'src/app/model/user';

@Component({
  selector: 'app-updateuser',
  templateUrl: './updateuser.component.html',
  styleUrls: ['./updateuser.component.css']
})
export class UpdateuserComponent implements OnInit {
  user:User=new User();
  id:any;
 constructor(private userservice:UserserviceService,private routerActive:ActivatedRoute,
   private router:Router) { }

 ngOnInit(): void {
   this.id=this.routerActive.snapshot.params['id'];
   this.userservice.getuserById(this.id).subscribe(data =>{
     this.user=data;
   },
   error =>console.log(error)
   );

 }
 onSubmit(){
   this.userservice.updateuser(this.id,this.user).subscribe(
     data =>{
       console.log(data);
       this.goTouserList();
     },
     error => console.log(error)
   )
 }

 goTouserList(){
   this.router.navigate(['/getuserlist']);
 }


}
