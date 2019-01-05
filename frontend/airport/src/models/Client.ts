import {Person} from './Person';

export class Client {
  id: number;
  person: Person;
  constructor (id: number, person: Person) {
    this.id = id;
    this.person = person;
  }
}
