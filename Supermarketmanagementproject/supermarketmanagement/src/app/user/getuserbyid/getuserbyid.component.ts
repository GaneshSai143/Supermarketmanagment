import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserserviceService } from 'src/app/login/Service/userservice.service';
import { User } from 'src/app/model/user';

@Component({
  selector: 'app-getuserbyid',
  templateUrl: './getuserbyid.component.html',
  styleUrls: ['./getuserbyid.component.css']
})
export class GetuserbyidComponent implements OnInit {

  id: any;
  user: any;
  constructor(private route: ActivatedRoute, private userservice: UserserviceService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.user = new User();
    this.userservice.getuserById(this.id).subscribe( data => {
      this.user = data;
    });
  }

}
