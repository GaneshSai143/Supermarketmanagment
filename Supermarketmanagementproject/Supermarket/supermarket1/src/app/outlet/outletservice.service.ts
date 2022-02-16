import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Outlets } from './outlets';

@Injectable({
  providedIn: 'root'
})
export class OutletserviceService {
  private baseURL1 ='http://localhost:8091/outlets';
  private baseURL2 ='http://localhost:8091/outlets/sendemail';
  private baseURL3 ='http://localhost:8091/outlets/get';
  
    constructor(private httpClient:HttpClient) { }
  
    getoutletList():Observable<Outlets[]>{
      return this.httpClient.get<Outlets[]> (`${this.baseURL3}`);
    }

    getoutletList1():Observable<Outlets[]>{
      return this.httpClient.get<Outlets[]> (`${this.baseURL3}`);
    }
  
    createuseroutlet(outlet:Outlets):Observable<any>{
      return this.httpClient.post(`${this.baseURL1}`,outlet);
    }
  
    getoutletById(id:number):Observable<Outlets>{
        return this.httpClient.get<Outlets>(`${this.baseURL1}/${id}`);
    }
  
    updateoutlet(id:number,outlet:Outlets):Observable<Object>{
      return this.httpClient.put(`${this.baseURL1}/${id}`,outlet);
    }
  
    deleteoutlet(id:number):Observable<object>{
      return this.httpClient.delete(`${this.baseURL1}/${id}`);
    }
    productsendemail(id:number):Observable<Outlets>{
      return this.httpClient.get<Outlets>(`${this.baseURL2}/${id}`);
    }
}
