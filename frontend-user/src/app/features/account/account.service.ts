import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs'; 
import { Account } from '@shared/modules/account.model';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  private STORAGE_KEY = 'account_data_json';
  constructor() {
    // Kiểm tra xem LocalStorage có dữ liệu chưa, nếu chưa thì tạo data mẫu
    if (!localStorage.getItem(this.STORAGE_KEY)) {
      const mockData = [
        { id: 1, username: 'admin', email: 'admin@web.com', role: 'Admin' },
        { id: 2, username: 'user1', email: 'user1@web.com', role: 'User' }
      ];
      localStorage.setItem(this.STORAGE_KEY, JSON.stringify(mockData));
    }
  }

  // --- HÀM HỖ TRỢ ĐỌC/GHI LOCALSTORAGE ---
  private getData(): Account[] {
    const data = localStorage.getItem(this.STORAGE_KEY);
    return data ? JSON.parse(data) : [];
  }

  private saveData(data: Account[]): void {
    localStorage.setItem(this.STORAGE_KEY, JSON.stringify(data));
  }

  // --- CÁC HÀM CRUD (Giả lập Async bằng Observable) ---

  // 1. READ
  getAll(): Observable<Account[]> {
    return of(this.getData());
  }

  // 2. CREATE
  create(account: Account): Observable<boolean> {
    const currentData = this.getData();
    
    // Tự sinh ID (Lấy ID lớn nhất + 1)
    const newId = currentData.length > 0 ? Math.max(...currentData.map(d => d.id)) + 1 : 1;
    account.id = newId;

    currentData.push(account);
    this.saveData(currentData);
    
    return of(true);
  }

  // 3. UPDATE
  update(account: Account): Observable<boolean> {
    const currentData = this.getData();
    const index = currentData.findIndex(x => x.id === account.id);
    
    if (index !== -1) {
      currentData[index] = account;
      this.saveData(currentData);
      return of(true);
    }
    return of(false);
  }

  // 4. DELETE
  delete(id: number): Observable<boolean> {
    let currentData = this.getData();
    const initialLength = currentData.length;
    
    currentData = currentData.filter(x => x.id !== id);
    
    if (currentData.length < initialLength) {
      this.saveData(currentData);
      return of(true);
    }
    return of(false);
  }
}