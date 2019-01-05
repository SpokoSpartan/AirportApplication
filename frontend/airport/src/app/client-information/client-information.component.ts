import {Component, OnInit} from '@angular/core';
import {MessageInfo} from '../../models/MessageInfo';
import {ActivatedRoute, Router} from '@angular/router';
import {RestService} from '../../services/rest/rest.service';
import {Course} from '../../models/Course';
import {Person} from '../../models/Person';
import {Client} from '../../models/Client';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Ticket} from '../../models/Tickets';

@Component({
  selector: 'app-client-information',
  templateUrl: './client-information.component.html',
  styleUrls: ['./client-information.component.css']
})
export class ClientInformationComponent implements OnInit {

  course: Course;
  classId: number;
  class: string;
  clientParams: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private http: RestService,
              private router: Router) { }

  ngOnInit() {
    this.getCourse();
    this.initFormGroup();
  }

  createClientAndTicket(params: any) {
    const person: Person = new Person(null, this.clientParams.value.firstName,
      this.clientParams.value.lastName, this.clientParams.value.idCardNumber,
      this.clientParams.value.city, this.clientParams.value.email,
      this.clientParams.value.phoneNumber);
    const body = new Ticket(null, this.class, new Client(null, person), this.course.id);
    console.log(body);
    this.http.save('ticket', body).subscribe((response) => {
    if (response.success) {
      this.router.navigateByUrl('/ticket-bought-successfully');
    } else {
      this.router.navigateByUrl('/error');
    }
  });
  }

  initFormGroup() {
    this.clientParams = this.formBuilder.group({
      firstName: ['', [Validators.required]],
      lastName: ['', [Validators.required]],
      idCardNumber: ['', [Validators.required]],
      city: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', [Validators.required, Validators.minLength(9), Validators.maxLength(11)]]
    });
  }

  async getCourse() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.classId = +this.route.snapshot.paramMap.get('class');
    if (this.classId === 1) {
      this.class = 'Ekonomiczna';
    } else if (this.classId === 2) {
      this.class = 'Premium';
    } else {
      this.class = 'Biznesowa';
    }
    const response: MessageInfo = await this.http.getOne('course/getOne', id);
    this.course = response.object;
  }
}
