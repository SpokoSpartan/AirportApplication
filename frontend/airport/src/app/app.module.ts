import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule} from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PricingComponent } from './pricing/pricing.component';
import { ClientInformationComponent } from './client-information/client-information.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    PricingComponent,
    ClientInformationComponent
  ],
  imports: [
    BrowserModule,
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
        path: 'pricing',
        component: PricingComponent
      },
      {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'add-data',
        component: ClientInformationComponent
      }
    ]),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
