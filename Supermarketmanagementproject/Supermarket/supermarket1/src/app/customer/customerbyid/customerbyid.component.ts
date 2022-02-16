import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/user';
import { CustomerserviceService } from '../customerservice.service';

@Component({
  selector: 'app-customerbyid',
  templateUrl: './customerbyid.component.html',
  styleUrls: ['./customerbyid.component.css']
})
export class CustomerbyidComponent implements OnInit {
  id: any;
  user: any;
  constructor(private route: ActivatedRoute, private userservice:CustomerserviceService,private router:Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.user = new User();
    this.userservice.getuserById(this.id).subscribe( data => {
      this.user = data;
    });
  }
  goback()
  {
    this.router.navigate(['customer/customerlist']);
  }

}
