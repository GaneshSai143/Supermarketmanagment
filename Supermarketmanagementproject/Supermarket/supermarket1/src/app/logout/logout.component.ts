import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthserviceService } from '../authservice.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  message = '';
  isLoadingResults = false;
  constructor(private authService: AuthserviceService, private router: Router) { }
  danger:any=false;
  ngOnInit(): void {
    this.danger=true;
      this.logout();
  }

  logout(){
    this.authService.logout();
    this.router.navigate(['login']).then(_ => this.danger=true);
    
  }



}
