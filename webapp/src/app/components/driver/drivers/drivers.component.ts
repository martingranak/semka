import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../../shared/employee/employee.service';
import { Driver } from '../../../models/driver'
import { Router } from '@angular/router'; 
@Component({
  selector: 'app-drivers',
  templateUrl: './drivers.component.html',
  styleUrls: ['./drivers.component.css']
})
export class DriversComponent implements OnInit {
  drivers: Driver[];

  selctedDriver: Driver;
  
  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit() {
    this.getDrivers();
  }

  onSelect(driver: Driver): void {
    this.router.navigate(['/driver-view', driver.id]);
  }

  getDrivers(): void {
    this.employeeService.getAll().subscribe(data => {
      this.drivers = data;
    });
  }

  deleteDriver(id: any): void {
    this.employeeService.removeEmployee(id).subscribe(() => {
      this.getDrivers();
    });
  }
}
