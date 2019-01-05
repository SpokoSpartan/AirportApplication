export class Plane {
  id: number;
  capacity: number;
  manufacturer: string;
  version: string;
  numberOfPilots: number;
  numberOfHostess: number;

  constructor(id: number, capacity: number, manufacturer: string, version: string,
              numberOfPilots: number, numberOfHostess: number) {
    this.id = id;
    this.capacity = capacity;
    this.manufacturer = manufacturer;
    this.version = version;
    this.numberOfPilots = numberOfPilots;
    this.numberOfHostess = numberOfHostess;
  }
}
