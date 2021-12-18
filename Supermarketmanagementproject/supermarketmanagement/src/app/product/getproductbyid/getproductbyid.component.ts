import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/model/product';
import { ProductserviceService } from '../productservice.service';

@Component({
  selector: 'app-getproductbyid',
  templateUrl: './getproductbyid.component.html',
  styleUrls: ['./getproductbyid.component.css']
})
export class GetproductbyidComponent implements OnInit {
  id: any;
  product: any;
  constructor(private route: ActivatedRoute, private pservice:ProductserviceService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.product = new Product();
    this.pservice.getproductById(this.id).subscribe( data => {
      this.product = data;
    });
  }

}
