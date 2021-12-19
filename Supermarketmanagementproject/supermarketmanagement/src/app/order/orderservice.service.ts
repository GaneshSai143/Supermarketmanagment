import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../order';

@Injectable({
  providedIn: 'root'
})
export class OrderserviceService {
  private baseURL1 ='http://localhost:8091/orders/orders';
  private baseURL2 ='http://localhost:8091/orders/productqupdate';
  private baseURL3 ='http://localhost:8091/orders/orderdelete';
  
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
  
    updateproduct(id:number,order:Order):Observable<Object>{
      return this.httpClient.put(`${this.baseURL1}/${id}`,order);
    }
  
    deleteproduct(id:number):Observable<object>{
      return this.httpClient.delete(`${this.baseURL3}/${id}`);
    }
    productupdatesend(id:number):Observable<Order>{
      return this.httpClient.get<Order>(`${this.baseURL2}/${id}`);
    }
}
