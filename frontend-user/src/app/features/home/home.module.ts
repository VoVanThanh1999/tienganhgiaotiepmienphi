import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { SharedModule } from '@shared/shared.module';

import { HomeRoutingModule } from './home-routing.module';
import { WelcomeComponent } from './pages';
import { HomeComponent } from './pages/home/home.component';

@NgModule({
  declarations: [WelcomeComponent, HomeComponent],
  imports: [CommonModule, HomeRoutingModule, SharedModule]
})
export class HomeModule {}
