import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {
  private baseURL1 ='http://localhost:8091/products/product';
  private baseURL2 ='http://localhost:8091/products/products';
  private baseURL3 ='http://localhost:8091/products/productdelete'
  
    constructor(private httpClient:HttpClient) { }
  
    getproductList():Observable<Product[]>{
      return this.httpClient.get<Product[]> (`${this.baseURL2}`);
    }
  
    createproduct(product:Product):Observable<any>{
      return this.httpClient.post(`${this.baseURL1}`,product);
    }
  
    getproductById(id:number):Observable<Product>{
        return this.httpClient.get<Product>(`${this.baseURL1}/${id}`);
    }
  
    updateproduct(id:number,product:Product):Observable<Object>{
      return this.httpClient.put(`${this.baseURL2}/${id}`,product);
    }
  
    deleteproduct(id:number):Observable<object>{
      return this.httpClient.delete(`${this.baseURL3}/${id}`);
    }
}
