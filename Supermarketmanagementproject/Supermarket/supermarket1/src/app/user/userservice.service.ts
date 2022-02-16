import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {
  private baseURL1 ='http://localhost:8091/customerregister';
  private baseURL2 ='http://localhost:8091/users';
    constructor(private httpClient:HttpClient) { }
  
    getusersList():Observable<User[]>{
      return this.httpClient.get<User[]> (`${this.baseURL2}`);
    }
  
    createuser(user:User):Observable<Object>{
      return this.httpClient.post(`${this.baseURL1}`,user);
    }
  
    getuserById(id:number):Observable<User>{
        return this.httpClient.get<User>(`${this.baseURL2}/${id}`);
    }

    getuserbyemail(emailId:any):any{
      let baseUrl1="http://localhost:8091/users/get/"+emailId+"?access_token="+localStorage.getItem("access_token");
    return this.httpClient.get<User>(`${baseUrl1}`);  

    }
  
    updateuser(id:number,user:User):Observable<Object>{
      return this.httpClient.put(`${this.baseURL2}/${id}`,user);
    }
  
    deleteuser(id:number):Observable<object>{
      return this.httpClient.delete(`${this.baseURL2}/${id}`);
    }
  
}
