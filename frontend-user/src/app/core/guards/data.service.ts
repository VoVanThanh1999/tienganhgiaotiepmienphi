import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpErrorResponse,
  // HttpHeaders,
} from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import {  catchError,  map } from 'rxjs/operators';
import { AuthService } from './auth.service';

// const headers = new HttpHeaders({
//   'Content-Type': 'application/json',
//   'Access-Control-Allow-Origin': '*',
// });
@Injectable({
  providedIn: 'root',
})
export class DataService {
  private REST_API_SERVER = 'http://localhost:5000/api/';

  constructor(
    private httpClient: HttpClient,
    private authService: AuthService
  ) {}

  public getUsers(backUrl: any): Observable<any> {
    return (
      this.httpClient
        .get(this.REST_API_SERVER + 'users')
        // .pipe(delay(3000))
        .pipe(
          map((data) => {
            console.log('DataService: getUsers', data);
            if (Object.prototype.hasOwnProperty.call(data, 'error')) {
              console.log('DataService: getUsers: error', data);
              this.authService.removeToken();
              this.authService.login(backUrl);
            }
            return data;
          })
        )
        .pipe(catchError(this.handleError))
    );
  }

  handleError(error: HttpErrorResponse): Observable<any> {
    let errorMessage = 'Unknown error!';
    console.log('DataService: handleError', error);
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