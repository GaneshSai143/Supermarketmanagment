import { Component, OnInit,Type } from '@angular/core';
import { ConditionalExpr } from '@angular/compiler';
import { Router } from '@angular/router';
import { User } from 'src/app/user';
import { UserserviceService } from '../userservice.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NgxSpinnerService } from 'ngx-spinner';


@Component({
  selector: 'app-customerregister',
  templateUrl: './customerregister.component.html',
  styleUrls: ['./customerregister.component.css']
})
export class CustomerregisterComponent implements OnInit {

  user:User=new User();
  createForm: any;
 duplicate:boolean=false;
 message:boolean=false;
 danger:boolean=false;

  constructor(private Userservice:UserserviceService,private router:Router,
    private formbuilder:FormBuilder,private spinner:NgxSpinnerService) { 
    
  }

  clear(){
    this.message=false;
  }
  ngOnInit(): void {
   
    this.createForm = new FormGroup({
      'firstName' : new FormControl(null, Validators.required),
      'emailId' : new FormControl(null, [Validators.required, Validators.pattern('^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$')
    ]),
      'lastName':new FormControl(null,Validators.required),
      'password':new FormControl(null,[Validators.required,Validators.pattern
        ('(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!#^~%*?&,.<>"\'\\;:\
        {\\\}\\\[\\\]\\\|\\\+\\\-\\\=\\\_\\\)\\\(\\\)\\\`\\\/\\\\\\]])[A-Za-z0-9\d$@].{7,}')]),
      'roletype':new FormControl(null,Validators.required)
      
    });
  }


  private saveuser(){
    this.spinner.show();
    this.Userservice.createuser(this.createForm.value).subscribe (data => {
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

  goToUserList(){
    this.router.navigate(['user/getuserlist'])
  }

  onSubmit(){
    console.log(this.user)
    this.saveuser();

  }

  
get firstName() {
  return this.createForm.get('firstName');
}
get emailId() {
  return this.createForm.get('emailId');
}
get password()
{
  return this.createForm.get('password');
}
get lastName() {
  return this.createForm.get('lastName');
}
get roletype() {
  return this.createForm.get('roletype');
}
reset(){
  this.duplicate=false;
}
}
