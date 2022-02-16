import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class CustomerserviceService {
  private baseURL1 ='http://localhost:8091/customer';

    constructor(private httpClient:HttpClient) { }
  
    getusersList():Observable<User[]>{
      return this.httpClient.get<User[]> (`${this.baseURL1}`);
    }
  
  
    getuserById(id:number):Observable<User>{
        return this.httpClient.get<User>(`${this.baseURL1}/${id}`);
    }
  
    updateuser(id:number,user:User):Observable<Object>{
      return this.httpClient.put(`${this.baseURL1}/${id}`,user);
    }
  
    deleteuser(id:number):Observable<object>{
      return this.httpClient.delete(`${this.baseURL1}/${id}`);
    }
}
