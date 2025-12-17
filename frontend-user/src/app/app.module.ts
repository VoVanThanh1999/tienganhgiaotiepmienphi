import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TransferHttpCacheModule } from '@nguniversal/common';

import { CoreModule } from '@core/core.module';

import { AppComponent } from './app.component';
// import { AccountComponent } from '@features/account/account.component';
import { AppRoutingModule } from './app-routing.module';
import { SharedModule } from './shared/shared.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {
  MatFormFieldModule,
  MAT_FORM_FIELD_DEFAULT_OPTIONS,
} from '@angular/material/form-field';

import { Interceptor } from './core/guards/Interceptor';
import { DialogLoginComponent } from './core/dialog-login/dialog-login.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input'; 

@NgModule({
  declarations: [AppComponent,DialogLoginComponent,],
  imports: [
    // SSR - Angular Universal
    BrowserModule.withServerTransition({ appId: 'angular-skeleton' }),
    TransferHttpCacheModule,

    // Application modules
    CoreModule.forRoot(),
    SharedModule.forRoot(),

    // Application routing
    AppRoutingModule,

    MatFormFieldModule,
    HttpClientModule,
    BrowserModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule, 
    MatDialogModule,
    MatInputModule,
    
    
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true },
    {
      provide: MAT_FORM_FIELD_DEFAULT_OPTIONS,
      useValue: { appearance: 'fill' },
    },
  ],
  entryComponents: [DialogLoginComponent],
  bootstrap: [AppComponent],
})
export class AppModule {}
