// import {
//     HttpClient,
//     HttpErrorResponse,
//     HttpParams,
//   } from '@angular/common/http';
  import { Injectable } from '@angular/core';
  import { MatDialog } from '@angular/material/dialog';
  import { Router } from '@angular/router';
  // import { Observable, throwError } from 'rxjs';
  // import { catchError } from 'rxjs/operators';
  import { DialogLoginComponent } from '../dialog-login/dialog-login.component';
  
  @Injectable({
    providedIn: 'root',
  })
  export class AuthService {
    constructor(private router: Router, public dialog: MatDialog) {}
  
    public setToken(token: string) {
      localStorage.setItem('token', token);
    }
  
    public removeToken() {
      localStorage.removeItem('token');
    }
  
    public getToken() {
      return localStorage.getItem('token');
    }
  
    public isLoggedIn(): boolean {
      return this.getToken() !== null;
    }
  
    public logout() {
      this.removeToken();
      this.router.navigate(['/']);
    }
  
    public login(backUrl: any): void {
      this.openDialog(backUrl);
    }
  
    private openDialog(backUrl: any): void {
      const dialogRef = this.dialog.open(DialogLoginComponent, {
        width: '250px',
        data: { username: '', password: '', token: '' },
      });
  
      dialogRef.afterClosed().subscribe((result) => {
        console.log('AuthService: afterClosed', result);
        const username = result?.data?.username;
        const password = result?.data?.password;
        const token = result?.data?.token;
        console.log(
          'AuthService: afterClosed',
          result,
          username,
          password,
          token
        );
        if (!!username && !!password && !!token) {
          this.setToken(token);
          this.router.navigate([backUrl]);
        } else {
          this.login(backUrl);
        }
      });
    }
  }