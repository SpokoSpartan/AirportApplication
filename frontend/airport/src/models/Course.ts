import {Airport} from './Airport';
import {Plane} from './Plane';

export class Course {
  id: number;
  departureDate: Date;
  arrivalDate: Date;
  availablePlaces: number;
  startAirport: Airport;
  endAirport: Airport;
  plane: Plane;
  price: any;
  constructor(id: number, departureDate: Date, arrivalDate: Date, availablePlaces: number,
              startAirport: Airport, endAirport: Airport, plane: Plane, price: any) {
    this.id = id;
    this.departureDate = departureDate;
    this.arrivalDate = arrivalDate;
    this.availablePlaces = availablePlaces;
    this.startAirport = startAirport;
    this.endAirport = endAirport;
    this.plane = plane;
    this.price = price;
  }
}
