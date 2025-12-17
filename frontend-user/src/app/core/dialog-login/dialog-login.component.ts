import { Component, Inject, OnInit } from '@angular/core';
import {
  // MatDialog,
  MatDialogRef,
  MAT_DIALOG_DATA,
} from '@angular/material/dialog';
import { AuthdataService } from '../guards/authdata.service';

export interface DialogData {
  username: string;
  password: string;
  token: string;
}

@Component({
  selector: 'app-dialog-login',
  templateUrl: './dialog-login.component.html',
  styleUrls: ['./dialog-login.component.scss'],
})
export class DialogLoginComponent implements OnInit {
  constructor(
    private authdataService: AuthdataService,
    public dialogRef: MatDialogRef<DialogLoginComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) {}

  ngOnInit(): void {}

  submitLogin(): void {
    console.log('DialogLoginComponent', this.data);
    // this.dialogRef.close({ data: this.data });
    this.authdataService
      .authLogin(this.data.username, this.data.password)
      .subscribe(
        (data: any) => {
          console.log('DialogLoginComponent: login, data = ', data);
          if (Object.prototype.hasOwnProperty.call(data, 'error')) {
            console.log('DialogLoginComponent: login: error', data);
          } else {
            this.data.token = data;
            console.log('DialogLoginComponent: this.data', this.data);
            this.dialogRef.close({ data: this.data });
          }
        },
        (error: any) => {
          console.log('AuthService: failed', error);
        }
      );
  }
}