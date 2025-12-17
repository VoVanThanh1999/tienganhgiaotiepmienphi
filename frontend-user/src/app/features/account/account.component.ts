import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AccountService } from './account.service';
import { Account } from '@shared/modules/account.model';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {
  formAccount: FormGroup;
  accounts: Account[] = [];
  isEditing = false;

  constructor(
    private fb: FormBuilder,
    private accountService: AccountService
  ) {
    this.formAccount = this.fb.group({
      id: [null], // ID ẩn
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      role: ['User']
    });
  }

  ngOnInit(): void {
    this.loadData();
  }

  loadData() {
    this.accountService.getAll().subscribe(data => {
      this.accounts = data;
    });
  }

  onSubmit() {
    if (this.formAccount.invalid) return;

    const formData = this.formAccount.value;

    if (this.isEditing) {
      // SỬA
      this.accountService.update(formData).subscribe(() => {
        this.loadData();
        this.resetForm();
        alert('Đã cập nhật!');
      });
    } else {
      // THÊM
      this.accountService.create(formData).subscribe(() => {
        this.loadData();
        this.resetForm();
        alert('Đã thêm mới!');
      });
    }
  }

  onEdit(acc: Account) {
    this.isEditing = true;
    this.formAccount.patchValue(acc); // Đổ dữ liệu vào form
  }

  onDelete(id: number) {
    if (confirm('Xóa nhé?')) {
      this.accountService.delete(id).subscribe(() => {
        this.loadData();
      });
    }
  }

  resetForm() {
    this.isEditing = false;
    this.formAccount.reset({ role: 'User' });
  }
}