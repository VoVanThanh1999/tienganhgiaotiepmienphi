import { Component } from '@angular/core';
import { AuthStateService } from './core/guards/AuthStateService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  constructor(private authState: AuthStateService) {}
  ngOnInit() {
    this.authState.initFromToken();
  }
}
