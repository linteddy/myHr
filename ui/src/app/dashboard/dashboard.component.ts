﻿import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from '../_services/authentication.service';
import {EmployeeService} from '../_services/employee.service';
import {Employee} from '../_models/employee';
import {EmployeeSearchPipe} from '../_helpers/employeeSearch.pipe';

@Component({
  selector: 'app-dashboard',
  templateUrl: 'dashboard.component.html',
  styleUrls: ['dashboard.component.css']
})

export class DashboardComponent implements OnInit {
  employees: Employee[] = [];
  maleEmployees: Employee[] = [];
  numberOfEmployees: number;
  numberOfMaleEmployees: number;
  numberOfFemaleEmployees: number;
  femaleEmployees: Employee[];
  employeesWithBirthdaysThisMonth: Employee[];
  numberOfBirthdaysThisMonth: number;
  filterText: string;

  constructor(private employeeService: EmployeeService, private authService: AuthenticationService) {
  }

  ngOnInit() {
    this.loadAllUsers();
  }

  private loadAllUsers() {
    this.employeeService.getAll().subscribe(data => {
      this.employees = data;
      this.numberOfEmployees = this.employees.length;
      this.loadFemaleEmployees();
      this.loadMaleEmployees();
      this.calculateNumberOfBirthdaysThisMonth();
    });
  }

  logout() {
    this.authService.logout();
  }

  private loadMaleEmployees() {
    this.maleEmployees = this.employees.filter(employee => employee.gender === 'M');
    this.numberOfMaleEmployees = this.maleEmployees.length;
  }

  private loadFemaleEmployees() {
    this.femaleEmployees = this.employees.filter(employee => employee.gender === 'F');
    this.numberOfFemaleEmployees = this.femaleEmployees.length;
  }

  private calculateNumberOfBirthdaysThisMonth(): void {
    const currentMonth: number = new Date().getMonth();
    this.employeesWithBirthdaysThisMonth = this.employees.filter( employee => new Date(employee.birth_date).getMonth() === currentMonth);
    this.numberOfBirthdaysThisMonth = this.employeesWithBirthdaysThisMonth.length;
  }

}
