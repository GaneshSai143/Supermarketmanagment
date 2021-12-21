import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthserviceService } from '../authservice.service';

@Component({
  selector: 'app-secure',
  templateUrl: './secure.component.html',
  styleUrls: ['./secure.component.css']
})
export class SecureComponent implements OnInit {
  message = '';
  isLoadingResults = false;

  constructor(private authService:AuthserviceService,private router:Router) { }

  ngOnInit(): void {
    this.isLoadingResults = true;
    this.authService.secure()
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

}
