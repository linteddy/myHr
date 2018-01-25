import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {routing} from './app.routing';

import {AlertComponent} from './_directives';
import {DashboardComponent} from './dashboard/dashboard.component';
import {LoginComponent} from './login/login.component';
import {StatsComponent} from './stats/stats.component';
import {AngularFontAwesomeModule} from 'angular-font-awesome';
import {AuthGuard} from './_guards/auth.guard';
import {AlertService} from './_services/alert.service';
import {AuthenticationService} from './_services/authentication.service';
import {EmployeeService} from './_services/employee.service';
import {JwtInterceptor} from './_helpers/jwt.intercepto;
import { ProfileComponent } from './profile/profile.component'r';


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    routing,
    AngularFontAwesomeModule,
  ],
  declarations: [
    AppComponent,
    AlertComponent,
    DashboardComponent,
    LoginComponent,
    StatsCompone,
    ProfileComponentnt,
  ],
  providers: [
    AuthGuard,
    AlertService,
    AuthenticationService,
    EmployeeService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})

export class AppModule {
}
