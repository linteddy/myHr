import {Component, OnInit} from '@angular/core';

import {User} from '../_models/user';
import {AuthenticationService} from '../_services/authentication.service';
import {EmployeeService} from '../_services/employee.service';
import {Employee} from '../_models/employee';

@Component({
  selector: 'app-dashboard',
  templateUrl: 'dashboard.component.html',
  styleUrls: ['dashboard.component.css']
})

export class DashboardComponent implements OnInit {
  currentUser: User;
  employees: Employee[] = [];

  constructor(private userService: EmployeeService, private authService: AuthenticationService) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  ngOnInit() {
    this.loadAllUsers();
  }

  private loadAllUsers() {
    this.userService.getAll().subscribe(data => {
      this.employees = data;
    });
  }

  logout() {
    this.authService.logout();
  }
}
