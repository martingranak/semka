import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class EmployeeService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8080/person/all');
  }

  getAllPaginated(id: any): Observable<any> {
    return this.http.get('//localhost:8080/person/drivers/id/' + id);
  }

  getOne(identityNumber: any): Observable<any> {
    return this.http.post('//localhost:8080/person/one', null, {
      params: {
        'identityNumber': identityNumber
      }
    });
  }

  getAllByName(firstName: string, lastname: string): Observable<any> {
    return this.http.get('//localhost:8080/person/name/' + firstName + ' ' + lastname);
  }

  getAllByFirstName(firstName: string): Observable<any> {
    return this.http.get('//localhost:8080/person/firstName/' + firstName);
  }

  getAllByLastName(lastName: string): Observable<any> {
    return this.http.get('//localhost:8080/person/lastName/' + lastName);
  }

  addEmployee(identityNumber: string, firstName: string, lastName: string, birthday: string): Observable<any> {
    return this.http.post('//localhost:8080/person/add', null, {
      params: {
        'identityNumber': identityNumber,
        'firstName': firstName,
        'lastName': lastName,
        'birthday': birthday
      }
    });
  }

  updateEmployee(identityNumber: string, firstName: string, lastName: string, birthday: string) {
    var data = {
      'identityNumber': identityNumber,
      'firstName': firstName,
      'lastName': lastName,
      'birthday': birthday
    }

    return this.http.put('//localhost:8080/person/update', data);
  }

  removeEmployee(identityNumber: string) {
    return this.http.delete('//localhost:8080/person/remove', {
      params: {
        'identityNumber': identityNumber
      }
    });
  }
}
