import {Client} from './Client';

export class Ticket {
  id: number;
  travelClass: string;
  client: Client;
  courseId: number;
  constructor(id: number, travelClass: string, client: Client, courseId: number) {
    this.id = id;
    this.travelClass = travelClass;
    this.client = client;
    this.courseId = courseId;
  }
}
