export class UiUser {
  public name: String;
  public role: String;
  public avatar: String;

  constructor(name: String, role: String, avatar: String) {
    this.name = name;
    this.avatar = avatar;
    this.role = role;
  }
}
