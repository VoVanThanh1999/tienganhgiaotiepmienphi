import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";
import { User } from "../models/user";
import { TokenService } from "../services/auth.service";

@Injectable({ providedIn: 'root' })
export class UserStateService {
  private userSubject = new BehaviorSubject<User | null>(null);
  user$ = this.userSubject.asObservable();

  constructor(private tokenService: TokenService) {
    const user = this.tokenService.getUserFromToken();
    this.userSubject.next(user);
  }

  setUser(user: User) {
    this.userSubject.next(user);
  }

  clear() {
    this.userSubject.next(null);
  }
}
