import {Component, OnInit} from '@angular/core';
import {EmployeeService} from '../_services/employee.service';
import {Employee} from '../_models/employee';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  employee: Employee;

  constructor(private employeeService: EmployeeService) {
  }

  ngOnInit() {
    this.loadProfile();
  }

  private loadProfile() {
    this.employeeService.getProfile().subscribe(
      res => {
        this.employee = res;
      }
    );
  }
}
