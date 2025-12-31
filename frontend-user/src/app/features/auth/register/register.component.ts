import { Component } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '@app/core/guards/auth.guard';
import { AuthStateService } from '@app/core/guards/AuthStateService';
import { UserStateService } from '@app/core/guards/UserStateService';
import { TokenService } from '@app/core/services/auth.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']

})
export class RegisterComponent {
  form: FormGroup;
page = {
    title: 'Đăng ký',
    description: 'Bắt đầu học tiếng Anh miễn phí – chỉ mất 1 phút ✨',

    image: {
      url: 'https://images.unsplash.com/photo-1503676260728-1c00da094a0b',
      title: 'Bắt đầu từ hôm nay',
      desc: 'Mỗi ngày một bài ngắn\nNói được – dùng được – tiến bộ thật'
    }
  };  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private tokenService: TokenService,
    private userState: UserStateService,
    private router: Router,
    private authState: AuthStateService
  ) {
    this.form = this.fb.group(
      {
        fullName: ['', [Validators.required, Validators.minLength(2)]],
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.minLength(6)]],
        confirmPassword: ['', Validators.required],
        agree: [false, Validators.requiredTrue],
      },
      { validators: this.passwordMatchValidator }
    );
  }

  // custom validator: password === confirmPassword
  passwordMatchValidator(group: AbstractControl): ValidationErrors | null {
    const password = group.get('password')?.value;
    const confirm = group.get('confirmPassword')?.value;
    return password === confirm ? null : { passwordMismatch: true };
  }

  register() {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const { fullName, email, password } = this.form.value;

    this.authService
      .register({ fullName, email, password })
      .subscribe({
        next: res => {
          this.tokenService.setAccessToken(res.accessToken);
          this.tokenService.setRefreshToken(res.refreshToken);
          const user = this.tokenService.getUserFromToken();

          if (user) {
            this.userState.setUser(user);
          }
          this.authState.setUserFromToken(); // KÍCH HOẠT HEADER
          this.router.navigate(['/']);
        },
        error: err => {
          console.error('Register failed', err);
        },
      });
  }

  // getters for template
  get f() {
    return this.form.controls;
  }
}