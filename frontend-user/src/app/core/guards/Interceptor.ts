import { Injectable } from '@angular/core';
import {
  HttpEvent,
  HttpInterceptor,
  HttpHandler,
  HttpRequest,
  HttpHeaders,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

const headers = new HttpHeaders({
  'Content-Type': 'application/json',
  'Access-Control-Allow-Origin': '*',
});
@Injectable()
export class Interceptor implements HttpInterceptor {
  constructor(private authService: AuthService) {}

  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {

    console.log('Interceptor request', request);

    // 1️⃣ Bỏ qua login
    if (request.url.includes('/login')) {
      return next.handle(request);
    }

    // 2️⃣ Có token
    const token = this.authService.getToken();
    if (token) {
      const myHeaders = headers.set(
        'Authorization',
        'Bearer ' + token
      );

      const authRequest = request.clone({
        headers: myHeaders
      });

      console.log('Interceptor headers', myHeaders);
      return next.handle(authRequest);
    }

    // 3️⃣ Không có token
    this.authService.login('/');

    // 🔴 BẮT BUỘC PHẢI RETURN
    return next.handle(request);
  }
}
