import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms"
import {Router} from "@angular/router";
import { CarService } from '../../../shared/car/car.service';

@Component({
  selector: 'app-car-create',
  templateUrl: './car-create.component.html',
  styleUrls: ['./car-create.component.css']
})
export class CarCreateComponent implements OnInit {

  constructor(private carService: CarService,private router: Router) { }

  carName: '';
  carType: '';
  carFuelType: '';
  carConsumption: '';
  file: Blob;

  ngOnInit() {
  }

  onFileChanged(event) {
   this.file = event.target.files[0]
  }
  onSubmit() {
    this.carService.addCar(this.carName, this.carType, this.carFuelType, this.carConsumption, this.file)
      .subscribe( data => {
        console.log(data);
      });
  }
}
