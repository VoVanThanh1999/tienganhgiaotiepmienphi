import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";
import { TokenService } from "../services/auth.service";
import { UiUser } from "../models/UiUser";

@Injectable({ providedIn: 'root' })
export class AuthStateService {
  private userSubject = new BehaviorSubject<UiUser | null>(null);
  user$ = this.userSubject.asObservable();

  constructor(private tokenService: TokenService) {}

  /** Gọi khi app start */
  initFromToken() {
    const jwtUser = this.tokenService.getUserFromToken();
    if (!jwtUser) return;

    this.userSubject.next(this.mapJwtToUi(jwtUser));
  }

  /** Gọi khi login / register thành công */
  setUserFromToken() {
    const jwtUser = this.tokenService.getUserFromToken();
    if (!jwtUser) return;

    this.userSubject.next(this.mapJwtToUi(jwtUser));
  }

  clear() {
    this.userSubject.next(null);
  }

  private mapJwtToUi(jwt: any): UiUser {
    return {
      name: jwt.fullName,
      role: this.mapRole(jwt.role),
      avatar: 'assets/images/avatar.png'
    };
  }

  mapRole(role: string): string {
    switch (role) {
      case "ADMIN":
        return "Administrator";
      case "USER":
        return "User";
      case "DESIGNER":
        return "UI/UX Designer";
      default:
        return role;
    }
  }
}
