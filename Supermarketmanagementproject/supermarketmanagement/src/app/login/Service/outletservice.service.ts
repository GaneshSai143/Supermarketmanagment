 import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Outlet } from 'src/app/model/outlet';
import { User } from 'src/app/model/user';

@Injectable({
  providedIn: 'root'
})
export class OutletserviceService {
  private baseURL1 ='http://localhost:8091/outlets/outlet';
  private baseURL2 ='http://localhost:8091/outlets/outlets';
  
    constructor(private httpClient:HttpClient) { }
  
    getoutletList():Observable<Outlet[]>{
      return this.httpClient.get<Outlet[]> (`${this.baseURL2}`);
    }
  
    createuseroutlet(outlet:Outlet,user:User):Observable<any>{
      return this.httpClient.post(`${this.baseURL2}`,outlet);
    }
  
    getoutletById(id:number):Observable<Outlet>{
        return this.httpClient.get<Outlet>(`${this.baseURL1}/${id}`);
    }
  
    updateoutlet(id:number,outlet:Outlet):Observable<Object>{
      return this.httpClient.put(`${this.baseURL1}/${id}`,outlet);
    }
  
    deleteoutlet(id:number):Observable<object>{
      return this.httpClient.delete(`${this.baseURL1}/${id}`);
    }
}
