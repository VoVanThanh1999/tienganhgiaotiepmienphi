import { Provider } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NgxIsrService } from './ngx-isr.service';
import * as i0 from "@angular/core";
export declare class HttpErrorsInterceptor implements HttpInterceptor {
    private ngxIsrService;
    constructor(ngxIsrService: NgxIsrService);
    intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>>;
    static ɵfac: i0.ɵɵFactoryDeclaration<HttpErrorsInterceptor, never>;
    static ɵprov: i0.ɵɵInjectableDeclaration<HttpErrorsInterceptor>;
}
export declare const HTTP_ERROR_PROVIDER_ISR: Provider;
