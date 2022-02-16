import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../orders/order';
import { Outlets } from '../outlet/outlets';
import { Products } from '../product/products';

@Injectable({
  providedIn: 'root'
})
export class ShopserviceService {
  private baseURL3 ='http://localhost:8091/shops/getproduct';
  private baseurl1 ='http://localhost:8091/shops';
  private baseurl4 ='http://localhost:8091/shops/get';
  private baseurl2 ='http://localhost:8091/shops/productqupdate';
  
  constructor(private httpClient:HttpClient) { }

  getproductList():Observable<Products[]>{
    return this.httpClient.get<Products[]> (`${this.baseURL3}`);
  }

  getorders():Observable<Order[]>{
    return this.httpClient.get<Order[]> (`${this.baseurl4}`);
  }
  getupdate(id:number):Observable<Order>{
    return this.httpClient.get<Order> (`${this.baseurl2}/${id}`);
  }

  getoutletname():Observable<Outlets[]>{
    return this.httpClient.get<Outlets[]>(`${this.baseurl1}`);
  }

  
}
