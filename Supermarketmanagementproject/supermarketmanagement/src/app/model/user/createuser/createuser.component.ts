import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { UserserviceService } from 'src/app/login/Service/userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-createuser',
  templateUrl: './createuser.component.html',
  styleUrls: ['./createuser.component.css']
})
export class CreateuserComponent implements OnInit {
user:User=new User();
  constructor(private Userservice:UserserviceService,private router:Router) { }

  ngOnInit(): void {
  }
  private saveuser(){
    this.Userservice.createuser(this.user).subscribe (data => {
      console.log(data);
      this.goToUserList();
    },
    error => console.log(error)
    );
  }

  goToUserList(){
    this.router.navigate(['/getuserlist'])
  }

  onSubmit(){
    console.log(this.user)
    this.saveuser();

  }

}
