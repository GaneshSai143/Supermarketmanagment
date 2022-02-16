import { Component, OnInit } from '@angular/core';
import { AuthserviceService } from '../authservice.service';

import {FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import { UserserviceService } from '../user/userservice.service'; 
import { User } from '../user';
import { ErrorStateMatcher } from '@angular/material/core';



export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user:User=new User();
  loginForm: FormGroup|any;
  username = '';
  password = '';
  isLoadingResults = false;
  matcher = new MyErrorStateMatcher();
  danger:boolean=false;

  constructor(private authService: AuthserviceService,
    private userService:UserserviceService,
    private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username : [null, Validators.required],
      password : [null, Validators.required]
    });
  }

  onFormSubmit(): void {
    this.isLoadingResults = true;
    this.authService.login(this.loginForm.value.username,this.loginForm.value.password)
      .subscribe(() => {
        this.isLoadingResults = false;
       // this.router.navigate(['/sucess']).then(_ => console.log('You are secure now!'));
      }, (err: any) => {
        console.log(err);
        this.danger=true;
        this.isLoadingResults = false;

      },()=>
      {
        this.getUser();
      }
      );
  }

  getUser(){
    this.userService.getuserbyemail(this.loginForm.value.username).subscribe(
      (data:any)=>{
        this.user = data;
        
        console.log(this.user.authorities);
         if(this.user.authorities[0].name==="ROLE_SUPER_ADMIN")
         {
          this.router.navigate(['/sucess']).then(_ => console.log('You are not loged in successfully!'));
         }
         else if(this.user.authorities[0].name==="ROLE_OUTLET_ADMIN"){
           this.router.navigate(['/outletsuccess']);
         }
         else if(this.user.authorities[0].name==="ROLE_CUSTOMER"){
            this.router.navigate(['/customersuccess'])
          
         }
        
    });
  }

}
