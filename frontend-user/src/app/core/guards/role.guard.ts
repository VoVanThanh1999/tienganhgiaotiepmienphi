import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate } from "@angular/router";

@Injectable({ providedIn: 'root' })
export class RoleGuard implements CanActivate {
  canActivate(route: ActivatedRouteSnapshot): boolean {
    const roles = route.data['roles'] as string[];
    const token = localStorage.getItem('access_token');

    if (!token) return false;

    const payload = JSON.parse(atob(token.split('.')[1]));
    return roles.includes(payload.role);
  }
}
