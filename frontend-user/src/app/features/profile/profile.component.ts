import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../core/guards/auth.service';
import { DataService } from '../../core/guards/data.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss'],
})
export class ProfileComponent implements OnInit {
  users = [];

  constructor(
    private dataService: DataService,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;

    this.dataService.getUsers('/profile').subscribe((data: { token: any; data: never[]; }) => {
      console.log('ProfileComponent: getUsers', data);
      this.authService.setToken(data?.token);
      if (Array.isArray(data.data)) {
        this.users = data.data;
      }
    });
  }
}