import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Products } from './products';

@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {
  private baseURL1 ='http://localhost:8091/products';
  private baseURL2 ='http://localhost:8091/products/get';
  
  
    constructor(private httpClient:HttpClient) { }
  
    getproductList():Observable<Products[]>{
      return this.httpClient.get<Products[]> (`${this.baseURL2}`);
    }

    getproductList1():Observable<Products[]>{
      return this.httpClient.get<Products[]> (`${this.baseURL2}`);
    }
  
    createproduct(product:Products):Observable<any>{
      return this.httpClient.post(`${this.baseURL1}`,product);
    }
  
    getproductById(id:number):Observable<Products>{
        return this.httpClient.get<Products>(`${this.baseURL1}/${id}`);
    }
  
    updateproduct(id:number,product:Products):Observable<Object>{
      return this.httpClient.put(`${this.baseURL1}/${id}`,product);
    }
  
    deleteproduct(id:number):Observable<object>{
      return this.httpClient.delete(`${this.baseURL1}/${id}`);
    }
}
