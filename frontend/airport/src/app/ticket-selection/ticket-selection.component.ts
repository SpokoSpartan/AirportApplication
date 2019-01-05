import { Component, OnInit } from '@angular/core';
import {Course} from '../../models/Course';
import {RestService} from '../../services/rest/rest.service';
import {MessageInfo} from '../../models/MessageInfo';

@Component({
  selector: 'app-ticket-selection',
  templateUrl: './ticket-selection.component.html',
  styleUrls: ['./ticket-selection.component.sass']
})
export class TicketSelectionComponent implements OnInit {

  allCourser: Course[] = [];
  allStartAirport: String[] = [];
  allEndAirport: String[] = [];

  constructor(private http: RestService) { }

  ngOnInit() {
    this.getAllCourses();
  }

  async getAllCourses() {
    const response: MessageInfo = await this.http.getAll('course/getAll');
    this.allCourser = response.object;
    this.airportToString();
  }

  airportToString() {
     for (const object of this.allCourser) {
      this.allEndAirport.push(object.endAirport.city + ' ' + object.endAirport.name);
      this.allStartAirport.push(object.startAirport.city + ' ' + object.startAirport.name);
     }
  }
}
