
export class User {
  public id?: number ;

  public email: string;

  public username: string;

  public fullName: string;

  public role: string;


  constructor(
    id: number,
    email: string,
    username: string,
    fullName: string,
    role: string,
  ) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.fullName = fullName;
    this.role = role;
  }
}
