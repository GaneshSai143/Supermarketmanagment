import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthserviceService } from '../authservice.service';

@Component({
  selector: 'app-sucess',
  templateUrl: './sucess.component.html',
  styleUrls: ['./sucess.component.css']
})
export class SucessComponent implements OnInit {

  message = '';
  isLoadingResults = false;

  constructor(private authService: AuthserviceService, private router: Router) { }

  ngOnInit(): void {
  
    this.isLoadingResults = true;
    this.authService.sucess()
      .subscribe((data: any) => {
        this.message = data;
        this.user();
        console.log(data);
        this.isLoadingResults = false;
      });
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/login']).then(_ => console.log('Logout'));
  }
  user(){
    this.router.navigate(['/user'])
  }
  Outlet(){
    this.router.navigate(['/outlet'])
  }
  order()
  {
    this.router.navigate(['/orders'])
  }

}
