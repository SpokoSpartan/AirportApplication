export class Person {
  id: number;
  name: string;
  surname: string;
  idCardNumber: string;
  city: string;
  email: string;
  phoneNumber: string;
  constructor(id: number, name: string, surname: string, idCardNumber: string,
              city: string, email: string, phoneNumber: string) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.idCardNumber = idCardNumber;
    this.city = city;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }
}
