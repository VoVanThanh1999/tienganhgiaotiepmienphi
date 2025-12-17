import { Injectable } from '@angular/core';
import {
  CanActivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService) {}

  canActivate(
    _route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
        
    // console.log('canActivate', route, state);
    // Check 1: Chặn URL bí mật
    if (state.url.includes('secret')) {
      console.error('Bạn không thể vào phòng bí mật này !');
      return false;
    }

    // Check 2: Kiểm tra đăng nhập
    if (this.authService.isLoggedIn()) {
      return true;
    } else {
      this.authService.login(state.url);
      return false; // <--- THÊM DÒNG NÀY: Chặn điều hướng vì chưa login
    }
  }
}