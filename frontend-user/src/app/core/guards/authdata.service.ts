import {
    HttpClient,
    HttpErrorResponse,
    HttpParams,
  } from '@angular/common/http';
  import { Injectable } from '@angular/core';
  import { Observable, throwError } from 'rxjs';
  import { catchError } from 'rxjs/operators';
  
  @Injectable({
    providedIn: 'root',
  })
  export class AuthdataService {
    private REST_API_SERVER = 'http://localhost:5000/api/users/login';
  
    constructor(private httpClient: HttpClient) {}
  
    public authLogin(username: any, password: any): Observable<any> {
      console.log('AuthService: authLogin: ', username, password);
      const httpParams = new HttpParams();
      const payload = { username, password };
      return (
        this.httpClient
          .post(this.REST_API_SERVER, payload, {
            params: httpParams,
          })
          // .pipe(delay(3000))
          // .pipe(map(data => {
          //   console.log('DataService: login', data);
          //   return data;
          // }))
          .pipe(catchError(this.handleError))
      );
    }
  
    handleError(error: HttpErrorResponse): Observable<any> {
      let errorMessage = 'Unknown error!';
      if (error.error instanceof ErrorEvent) {
        // Client-side errors
        errorMessage = `Error: ${error.error.message}`;
      } else {
        // Server-side errors
        errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
      }
      // window.alert(errorMessage);
      console.log('Error', errorMessage);
      return throwError(errorMessage);
    }
  }
