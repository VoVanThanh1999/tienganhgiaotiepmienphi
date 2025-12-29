import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '@app/core/guards/auth.guard';
import { AuthStateService } from '@app/core/guards/AuthStateService';
import { TokenService } from '@app/core/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;

  isLoading = false;

  constructor(private fb: FormBuilder, 
    private authService: AuthService,
    private tokenService: TokenService,
    private authState: AuthStateService,
    private router: Router) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      rememberMe: [false]
    });
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      this.isLoading = true;
      console.log('Dữ liệu đăng nhập:', this.loginForm.value);

      this.authService.login(this.loginForm.value as any).subscribe(res => {
        this.tokenService.setAccessToken(res.accessToken);
        this.tokenService.setRefreshToken(res.refreshToken);
        this.isLoading = false;
        this.authState.setUserFromToken(); // KÍCH HOẠT HEADER
        this.router.navigate(['/']);
      });
    } else {
      this.loginForm.markAllAsTouched();
    }
  }
}
