import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {routing} from './app.routing';

import {AlertComponent} from './_directives';
import {AuthGuard} from './_guards';
import {AlertService, AuthenticationService, UserService} from './_services';
import {DashboardComponent} from './dashboard/dashboard.component';
import {LoginComponent} from './login/login.component';
import {StatsComponent} from './stats/stats.component';
import {AngularFontAwesomeModule} from 'angular-font-awesome';

// used to create fake backend

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    routing,
    AngularFontAwesomeModule
  ],
  declarations: [
    AppComponent,
    AlertComponent,
    DashboardComponent,
    LoginComponent,
    StatsComponent,
  ],
  providers: [
    AuthGuard,
    AlertService,
    AuthenticationService,
    UserService,

  ],
  bootstrap: [AppComponent]
})

export class AppModule {
}
