import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {RestService} from '../../services/rest/rest.service';
import {MessageInfo} from '../../models/MessageInfo';
import {Course} from '../../models/Course';

@Component({
  selector: 'app-single-course-view',
  templateUrl: './single-course-view.component.html',
  styleUrls: ['./single-course-view.component.css']
})
export class SingleCourseViewComponent implements OnInit {

  course: Course;
  constructor(private route: ActivatedRoute, private http: RestService) { }

  ngOnInit() {
    this.getCourse();
  }

  async getCourse() {
    const id = +this.route.snapshot.paramMap.get('id');
    const response: MessageInfo = await this.http.getOne('course/getOne', id);
    this.course = response.object;
    this.coursePrice = this.course.price;
  }
}
