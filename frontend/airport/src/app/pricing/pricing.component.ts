import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {RestService} from '../../services/rest/rest.service';
import {MessageInfo} from '../../models/MessageInfo';
import {Course} from '../../models/Course';

@Component({
  selector: 'app-pricing',
  templateUrl: './pricing.component.html',
  styleUrls: ['./pricing.component.css']
})
export class PricingComponent implements OnInit {

  course: Course;
  constructor(private route: ActivatedRoute, private http: RestService) { }

  ngOnInit() {
    this.getCourse();
  }

  async getCourse() {
    const id = +this.route.snapshot.paramMap.get('id');
    const response: MessageInfo = await this.http.getOne('course/getOne', id);
    this.course = response.object;
  }
}
