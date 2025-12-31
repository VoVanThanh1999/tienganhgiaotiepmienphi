import { CacheData, CacheHandler, ISROptions } from "../models";
export declare class InMemoryCacheHandler implements CacheHandler {
    protected cache: Map<string, CacheData>;
    add(url: string, html: string, options?: ISROptions): Promise<void>;
    get(url: string): Promise<CacheData>;
    getAll(): Promise<string[]>;
    has(url: string): Promise<boolean>;
    delete(url: string): Promise<boolean>;
}
