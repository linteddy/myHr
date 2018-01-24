import {User} from './user';
import {Position} from './position';
import {EmployeeNextOfKin} from './employeeNextOfKin';
import {EmployeeReview} from './employeeReview';

export class Employee{
  id: number;
  user: User;
  position: Position;
  phone_number: string;
  email: string;
  github_user: string;
  birth_date: string;
  gender: string;
  race: string;
  years_worked: number;
  age: number;
  days_to_birthday: number;
  employed: boolean;
  foreigner: boolean;
  employee_next_of_kin: EmployeeNextOfKin[];
  employee_review: EmployeeReview[];
  id_number: string;
  tax_number: string;
  start_date: string;
  end_date: string;
  id_documnet: any;
  visa_document:any;
  is_employed:boolean;
  is_foreigner: boolean;
  next_review: string;
  leave_remaining: number;

}
