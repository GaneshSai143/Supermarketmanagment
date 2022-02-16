import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Outlets } from '../outlet/outlets';
import { Products } from '../product/products';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class OrderserviceService {
  private baseURL1 ='http://localhost:8091/orders';
  private baseURL2 ='http://localhost:8091/orders/productqupdate';
  private baseURL3 ='http://localhost:8091/customer/getproducts';
  private baseURL4 ='http://localhost:8091/customer/getoutlets';
  
    constructor(private httpClient:HttpClient) { }
  
    getorderList():Observable<Order[]>{
      return this.httpClient.get<Order[]> (`${this.baseURL1}`);
    }
  
    createorder(order:Order):Observable<any>{
      return this.httpClient.post(`${this.baseURL1}`,order);
    }
  
    getorderById(id:number):Observable<Order>{
        return this.httpClient.get<Order>(`${this.baseURL1}/${id}`);
    }
  
    updateorder(id:number,order:Order):Observable<Object>{
      return this.httpClient.put(`${this.baseURL1}/${id}`,order);
    }
  
    deleteorder(id:number):Observable<object>{
      return this.httpClient.delete(`${this.baseURL1}/${id}`);
    }
    productupdatesend(id:number):Observable<Order>{
      return this.httpClient.get<Order>(`${this.baseURL2}/${id}`);
    }

    getproducts():Observable<Products[]>{
      return this.httpClient.get<Products[]> (`${this.baseURL3}`);
    }

    getoutlets():Observable<Outlets[]>{
      return this.httpClient.get<Outlets[]> (`${this.baseURL4}`);
    }
}
