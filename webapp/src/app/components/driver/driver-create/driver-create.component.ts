import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../../shared/employee/employee.service';
import { Router } from '@angular/router'; 

@Component({
  selector: 'app-driver-create',
  templateUrl: './driver-create.component.html',
  styleUrls: ['./driver-create.component.css']
})
export class DriverCreateComponent implements OnInit {

  constructor(private employeeService: EmployeeService ,private router: Router) { }

  identifyNumber: '';
  firstName: '';
  lastName: '';
  birthday: '';

  ngOnInit() {
  }

  onSubmit() {
    this.employeeService.addEmployee(this.identifyNumber, this.firstName, this.lastName, this.birthday)
      .subscribe( data => {
        console.log(data);
      });
  }

}
