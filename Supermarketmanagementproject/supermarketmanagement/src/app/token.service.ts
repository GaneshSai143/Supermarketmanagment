import { Injectable } from '@angular/core';

const ACCESS_TOKEN = 'access_token';
const REFRESH_TOKEN = 'refresh_token';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }
  getToken(): string|any {
    return localStorage.getItem(ACCESS_TOKEN);
  }

  getRefreshToken(): string|any {
    return localStorage.getItem(REFRESH_TOKEN);
  }

  saveToken(token: string): void |any{
    localStorage.setItem(ACCESS_TOKEN, token);
  }

  saveRefreshToken(refreshToken: string): void |any{
    localStorage.setItem(REFRESH_TOKEN, refreshToken);
  }

  removeToken(): void {
    localStorage.removeItem(ACCESS_TOKEN);
  }

  removeRefreshToken(): void {
    localStorage.removeItem(REFRESH_TOKEN);
  }
}
