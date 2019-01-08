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
  page: number = 1;
  selctedDriver: Driver;
  
  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit() {
    this.getDrivers();
  }

  onSelect(driver: any): void {
    this.router.navigate(['/driver-view', driver]);
  }

  getDrivers(): void {
    this.employeeService.getAllPaginated(this.page).subscribe(data => {
      this.drivers = data;
    });
  }

  decreasePage(): void {
    if(this.page != 1){
      this.page -= 1;
      this.getDrivers();
    }
  }

  increasePage(): void {
      this.page += 1;
      this.getDrivers();
  }

  deleteDriver(id: any): void {
    this.employeeService.removeEmployee(id).subscribe(() => {
      this.getDrivers();
    });
  }
}
