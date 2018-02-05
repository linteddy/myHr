import {Pipe, PipeTransform} from '@angular/core';
import {Employee} from '../_models/employee';

@Pipe({
  name: 'employeeSearch'
})
export class EmployeeSearchPipe implements PipeTransform {
  transform(items: Employee[], filterText: string) {
    if (items && items.length && filterText) {
      return items.filter(item => {
        if (item.user.first_name.toLowerCase().indexOf(filterText.toLowerCase()) !== -1) {
          return true;
        }
        if ( item.email.toLowerCase().indexOf(filterText.toLowerCase()) !== -1) {
          return true;
        }
        if (item.user.last_name.toLowerCase().indexOf(filterText.toLowerCase()) !== -1) {
          return true;
        }
        return false;
      });
    }
    else {
      return items;
    }
  }
}
