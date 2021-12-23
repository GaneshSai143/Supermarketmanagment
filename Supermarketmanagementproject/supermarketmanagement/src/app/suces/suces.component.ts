
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthserviceService } from '../authservice.service';

@Component({
  selector: 'app-suces',
  templateUrl: './suces.component.html',
  styleUrls: ['./suces.component.css']
})
export class SucesComponent implements OnInit {

  message = '';
  isLoadingResults = false;

  constructor(private authService: AuthserviceService, private router: Router) { }

  ngOnInit(): void {
   // this.user();
   // this.outlet();
  //  this.product();
   // this.order();
    this.isLoadingResults = true;
    this.authService.suces()
      .subscribe((data: any) => {
        this.message = data;
        console.log(data);
        this.isLoadingResults = false;
      });
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/login']).then(_ => console.log('Logout'));
  }
  user(){
    this.router.navigate(['/user']);
  }
  outlet(){
    this.router.navigate(['/outlet']);
  }
  product(){
    this.router.navigate(['/product']);
  }
  order(){
    this.router.navigate(['/order']);
  }
  }


