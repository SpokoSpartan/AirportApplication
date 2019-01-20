import { Component, OnInit } from '@angular/core';
import {Employee} from '../../models/Employee';
import {MessageInfo} from '../../models/MessageInfo';
import {RestService} from '../../services/rest/rest.service';
import {Airport} from '../../models/Airport';
import {Plane} from '../../models/Plane';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-create-course',
  templateUrl: './create-course.component.html',
  styleUrls: ['./create-course.component.sass']
})
export class CreateCourseComponent implements OnInit {

  employees: Employee[] = [];
  airports: Airport[] = [];
  planes: Plane[] = [];

  minDate = new Date().getDate();
  areDataActual = false;

  courseParams: FormGroup;

  constructor(private http: RestService,
              private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.initFormGroup();
    this.getAllEmployees().then( () => {
      this.areDataActual = true;
    });
  }

  async getAllEmployees() {
    const response: MessageInfo = await this.http.getAll('employee/getAll');
    this.employees = response.object;

    const response2: MessageInfo = await this.http.getAll('plane/getAll');
    this.planes = response2.object;

    const response3: MessageInfo = await this.http.getAll('airport/getAll');
    this.airports = response3.object;
  }

  initFormGroup() {
    this.courseParams = this.formBuilder.group({
      startAirport: ['', [Validators.required]],
      endAirport: ['', [Validators.required]],
      plane: ['', Validators.required],
      price: ['', [Validators.required]],
      departureDate: ['', [Validators.required]],
      arrivalDate: ['', [Validators.required]],
      departureTime: ['', [Validators.required]],
      arrivalTime: ['', [Validators.required]],
      availablePlaces: ['', [Validators.required]]
    });
  }

  createCourse(params: any) {
    console.log(this.courseParams);
  }

}
