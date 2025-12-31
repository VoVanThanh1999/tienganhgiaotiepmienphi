import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { TokenService } from "../services/auth.service";
// import { User } from "../models/user";
import { Observable } from "rxjs";

@Injectable({ providedIn: 'root' })
export class AuthService {
  private API = 'http://localhost:8080/auth';

  constructor(
    private http: HttpClient,
    private tokenService: TokenService
  ) {}

  login(data: { username: string; password: string }) {
    return this.http.post<any>(`${this.API}/login`, data);
  }

  register(data: any): Observable<any> {
    return this.http.post<any>(`${this.API}/register`, data);
  }

  logout() {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.tokenService.getAccessToken()}`
    });
  
    // 2. Tạo Body tương ứng với LogoutRequest
    const body = {
      refreshToken: this.tokenService.getRefreshToken()
    };

    this.http.post<any>(`${this.API}/logout`, body, { headers });
    this.tokenService.clear();

  }
}
