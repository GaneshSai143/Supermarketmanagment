import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/user';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-getuserbyid',
  templateUrl: './getuserbyid.component.html',
  styleUrls: ['./getuserbyid.component.css']
})
export class GetuserbyidComponent implements OnInit {

  id: any;
  user: any;
  constructor(private route: ActivatedRoute, private userservice: UserserviceService,private router:Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.user = new User();
    this.userservice.getuserById(this.id).subscribe( data => {
      this.user = data;
    });
  }
  goback()
  {
    this.router.navigate(['user/getuserlist']);
  }
}
