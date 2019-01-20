import {Person} from './Person';
import {Function} from './Func';
import {Role} from './Role';

export  class Employee {
  id: number;
  fireDate: Date;
  hireDate: Date;
  salary: string;
  function: Function;
  person: Person;
  roles: Role[];

  constructor(id: number, fireDate: Date, hireDate: Date, salary: string,
              func: Function, person: Person, roles: Role[]) {
    this.id = id;
    this.fireDate = fireDate;
    this.hireDate = hireDate;
    this.salary = salary;
    this.function = func;
    this.person = person;
    this.roles = roles;
  }
}
