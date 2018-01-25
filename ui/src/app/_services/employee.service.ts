import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {User} from '../_models/user';
import {Employee} from '../_models/employee';

@Injectable()
export class EmployeeService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<Employee[]>('/api/v1/employees');
    }
    getById(id: number) {
        return this.http.get('/api/users/' + id);
    }

}
