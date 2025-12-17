import { ModuleWithProviders } from '@angular/core';
import { NgxIsrService } from './ngx-isr.service';
import * as i0 from "@angular/core";
export declare class NgxIsrModule {
    private isrService;
    constructor(isrService: NgxIsrService);
    static forRoot(): ModuleWithProviders<NgxIsrModule>;
    static ɵfac: i0.ɵɵFactoryDeclaration<NgxIsrModule, never>;
    static ɵmod: i0.ɵɵNgModuleDeclaration<NgxIsrModule, never, never, never>;
    static ɵinj: i0.ɵɵInjectorDeclaration<NgxIsrModule>;
}
