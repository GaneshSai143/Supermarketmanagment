import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/user';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {
private baseURL1 ='http://localhost:8091/customerregister';
private baseURL2 ='http://localhost:8091/user/user';
private baseURL3 ='http://localhost:8091/user/edit';
private baseURL4 ='http://localhost:8091/user/delete';

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

  updateuser(id:number,user:User):Observable<Object>{
    return this.httpClient.put(`${this.baseURL3}/${id}`,user);
  }

  deleteuser(id:number):Observable<object>{
    return this.httpClient.delete(`${this.baseURL4}/${id}`);
  }


}
