import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule} from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PricingComponent } from './pricing/pricing.component';
import { ClientInformationComponent } from './client-information/client-information.component';
import {HttpClientModule} from '@angular/common/http';
import { TicketSelectionComponent } from './ticket-selection/ticket-selection.component';
import { SingleCourseViewComponent } from './single-course-view/single-course-view.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { TicketBoughtComponent } from './ticket-bought/ticket-bought.component';
import { ErrorComponent } from './error/error.component';
import { AboutComponent } from './about/about.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    PricingComponent,
    ClientInformationComponent,
    TicketSelectionComponent,
    SingleCourseViewComponent,
    TicketBoughtComponent,
    ErrorComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    },
      {
        path: 'home',
        component: HomeComponent
      },
      {
        path: 'pricing/:id',
        component: PricingComponent
      },
      {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'add-data/:id/:class',
        component: ClientInformationComponent
      },
      {
        path: 'ticket-selection',
        component: TicketSelectionComponent
      },
      {
        path: 'single-course-view/:id',
        component: SingleCourseViewComponent
      },
      {
        path: 'ticket-bought-successfully',
        component: TicketBoughtComponent
      },
      {
        path: 'error',
        component: ErrorComponent
      },
      {
        path: 'about',
        component: AboutComponent
      },
    ]),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
