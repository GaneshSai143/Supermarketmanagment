import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import { TokenserviceService } from './tokenservice.service';
import { User } from './user';

const OAUTH_CLIENT = 'client-1';
const OAUTH_SECRET = 'admin';
const API_URL = `http://localhost:8091`;
const HTTP_OPTIONS = {
  headers: new HttpHeaders({
    'Content-Type': 'application/x-www-form-urlencoded',
  
    Authorization: 'Basic ' + btoa(OAUTH_CLIENT + ':' + OAUTH_SECRET)
  })
};

@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {
user:User=new User();
  redirectUrl = '';
  isLogin=false;
  

  private static handleError(error: HttpErrorResponse): any {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError(()=>  
        'Something bad happened; please try again later.');
  }

  private static log(message: string): any {
    console.log(message);
  }

  constructor(private http: HttpClient, private tokenService: TokenserviceService) {
  }

/*  login(loginData:any): Observable<any> {
    this.tokenService.removeToken();
    this.tokenService.removeRefreshToken();
    const body = new HttpParams()
      .set('username', loginData.username)
      .set('password', loginData.password)
      .set('grant_type', 'password');

    return this.http.post<any>(API_URL + 'oauth/token', body, HTTP_OPTIONS)
      .pipe(
        tap(res => {
          this.tokenService.saveToken(res.access_token);
          this.tokenService.saveRefreshToken(res.refresh_token);
        }),
        catchError(AuthserviceService.handleError)
      );
  }*/
  

  refreshToken(refreshData: any): Observable<any> {
    this.tokenService.removeToken();
    this.tokenService.removeRefreshToken();
    const body = new HttpParams()
      .set('refresh_token', refreshData.refresh_token)
      .set('grant_type', 'refresh_token');
    return this.http.post<any>(API_URL + '/oauth/token', body, HTTP_OPTIONS)
      .pipe(
        tap(res => {
          this.tokenService.saveToken(res.access_token);
          this.tokenService.saveRefreshToken(res.refresh_token);
        }),
        catchError(AuthserviceService.handleError)
      );
  }
danger:boolean=false;
  logout(): void {
    this.danger=true;
    this.tokenService.removeToken();
    this.tokenService.removeRefreshToken();
  }

  login(username:any, password:any): Observable<any>  {
   // localStorage.setItem('STATE','true')
     var data = "grant_type=password"+ "&username=" + username + "&password=" + password ;
    /* var reqHeader = new HttpHeaders({
       'Content-Type': 'application/x-www-form-urlencoded',
       Authorization: 'Basic ' + btoa(OAUTH_CLIENT + ':' + OAUTH_SECRET)
     })*/
   
     return this.http.post<any>(API_URL + '/oauth/token', data, HTTP_OPTIONS )
     .pipe(
       tap(res => {
         this.tokenService.saveToken(res.access_token);
         this.tokenService.saveRefreshToken(res.refresh_token);
       }),
       catchError(AuthserviceService.handleError)
     );
 
   }
  /* register(data: any): Observable<any> {
     return this.http.post<any>(API_URL + 'oauth/signup', data)
       .pipe(
         tap(_ => AuthService.log('register')),
         catchError(AuthService.handleError)
       );
   }*/
 
  sucess(): Observable<any> {
     return this.http.get<any>(API_URL + 'secret')
       .pipe(catchError(AuthserviceService.handleError));
   }
 
   isLoggedIn(){
     const loggedIn=localStorage.getItem('STATE')
   }
 
}
