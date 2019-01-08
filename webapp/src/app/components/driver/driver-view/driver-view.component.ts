import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../../shared/employee/employee.service';
import { Driver } from '../../../models/driver'
import { ActivatedRoute } from '@angular/router'; 

@Component({
  selector: 'app-driver-view',
  templateUrl: './driver-view.component.html',
  styleUrls: ['./driver-view.component.css']
})
export class DriverViewComponent implements OnInit {

  driver: Driver;
  update: Boolean = false;

  constructor(private route: ActivatedRoute, private employeeService: EmployeeService) { }

  
  ngOnInit() {
    this.getDriver(this.route.snapshot.paramMap.get("id"));
    
  }

  updateDriver():void {
    this.update = !this.update;
  }

  getDriver(id:any): void {
    this.employeeService.getOne(id).subscribe(data => {
      this.driver = data;
    });
  }

  onSubmit(): void {
    this.employeeService.updateEmployee(this.driver.id, this.driver.firstName, this.driver.lastName, this.driver.birthday)
    .subscribe(() => {
      this.update = false;
    });
  }


}
