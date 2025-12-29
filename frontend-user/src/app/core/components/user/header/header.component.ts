import { DOCUMENT } from "@angular/common";
import { Component, Inject } from "@angular/core";

import { Cookie } from "@app/core/enums";
import { AuthService } from "@app/core/guards/auth.guard";
import { AuthStateService } from "@app/core/guards/AuthStateService";
import { UiUser } from "@app/core/models/UiUser";
import { StorageService } from "@app/shared/services";
import { environment } from "@env/environment";
import { Observable } from "rxjs";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.scss"],
})
export class HeaderComponent {
  isLoggedIn = false; // Mặc định là chưa đăng nhập

  isDropdownOpen = false; // Trạng thái ẩn/hiện menu profile

  user$!: Observable<UiUser | null>;

  public readonly logo = "/assets/images/logo.svg";

  public readonly lightAvatar =
    "https://ui-avatars.com/api/?background=222&color=f5f5f4&size=88&name=Borja+Paz&rounded=false&background=404040";

  public readonly darkAvatar =
    "https://ui-avatars.com/api/?background=222&color=404040&size=88&name=Borja+Paz&rounded=false&background=f5f5f4";

  public readonly title = environment.appName;

  public readonly version = environment.appVersion;

  public isDarkMode = this.getIsDarkMode();

  constructor(
    @Inject(DOCUMENT) private readonly document: Document,
    private readonly storageService: StorageService,
    private authService: AuthService,
    private authState: AuthStateService  ) {
    this.setIsDarkMode(this.isDarkMode);
  }


  ngOnInit() {
    // Kiểm tra token trong localStorage để cập nhật trạng thái
    this.isLoggedIn = !!localStorage.getItem("access_token");
    // this.isLoggedIn = true;
    this.user$ = this.authState.user$;

    console.log("this.user$",this.user$)
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

  toggleDropdown() {
    this.isDropdownOpen = !this.isDropdownOpen;
  }

  logout() {
    this.authService.logout();
    this.isLoggedIn = false;
    window.location.reload(); // Hoặc điều hướng về trang chủ
  }

  public toggleDarkMode(): void {
    this.isDarkMode = !this.isDarkMode;
    this.setIsDarkMode(this.isDarkMode);
  }

  private getIsDarkMode(): boolean {
    return this.storageService.getCookie(Cookie.DARK_MODE)
      ? this.storageService.getCookie(Cookie.DARK_MODE) === "1"
      : environment.darkModeAsDefault;
  }

  private setIsDarkMode(enabled: boolean): void {
    this.storageService.saveCookie(
      Cookie.DARK_MODE,
      this.isDarkMode ? "1" : "0",
      90
    );
    this.document.documentElement.className = enabled ? "dark" : "";
  }
}
