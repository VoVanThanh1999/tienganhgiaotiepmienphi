import { Injectable } from "@angular/core";
import { jwtDecode } from "jwt-decode";
import { User } from "../models/user";

interface JwtPayload {
  userId: number;
  username: string;
  email: string;
  fullName: string;
  role: string;
}

@Injectable({ providedIn: "root" })
export class TokenService {
  private TOKEN_KEY = "access_token";
  private TOKEN_KEY_REFRESH = "refresh_token";

  setAccessToken(token: string) {
    localStorage.setItem(this.TOKEN_KEY, token);
  }

  getAccessToken(): string | null {
    return localStorage.getItem(this.TOKEN_KEY);
  }

  setRefreshToken(token: string) {
    localStorage.setItem(this.TOKEN_KEY_REFRESH, token);
  }

  getRefreshToken(): string | null {
    return localStorage.getItem(this.TOKEN_KEY_REFRESH);
  }

  clear() {
    localStorage.removeItem(this.TOKEN_KEY);
    localStorage.removeItem(this.TOKEN_KEY_REFRESH);
  }

  isLoggedIn(): boolean {
    return !!this.getAccessToken();
  }

  getUserFromToken(): User | null {
    const token = this.getAccessToken();

    if (!token || typeof token !== "string") {
      return null;
    }

    // ❗ Token phải có 3 phần
    if (token.split(".").length !== 3) {
      console.warn("Invalid JWT format:", token);
      return null;
    }

    try {
      const payload = jwtDecode<JwtPayload>(token);

      console.log("payload", payload);

      return {
        id: payload.userId,
        fullName: payload.fullName,
        email: "",
        role: payload.role,
        username: "",
      };
    } catch (error) {
      console.error("Invalid token:", error);
      return null;
    }
  }
}
