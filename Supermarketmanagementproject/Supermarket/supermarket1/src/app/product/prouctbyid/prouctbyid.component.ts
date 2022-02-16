import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Products } from '../products';
import { ProductserviceService } from '../productservice.service';

@Component({
  selector: 'app-prouctbyid',
  templateUrl: './prouctbyid.component.html',
  styleUrls: ['./prouctbyid.component.css']
})
export class ProuctbyidComponent implements OnInit {
  id: any;
  product: any;
  constructor(private route: ActivatedRoute, private pservice: ProductserviceService,
    private router:Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.product = new Products();
    this.pservice.getproductById(this.id).subscribe( data => {
      this.product = data;
    });
  }
  goback()
  {
    this.router.navigate(['/product/productlist'])
  }

}
