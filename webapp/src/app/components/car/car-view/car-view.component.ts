import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'; 
import { CarService } from '../../../shared/car/car.service';
import { Car } from '../../../models/car'

@Component({
  selector: 'app-car-view',
  templateUrl: './car-view.component.html',
  styleUrls: ['./car-view.component.css']
})
export class CarViewComponent implements OnInit {

  car: Car;
  update: Boolean = false;

  constructor(private route: ActivatedRoute, private carService: CarService) { }

  
  ngOnInit() {
    this.getCar(this.route.snapshot.paramMap.get("id"));
    
  }

  updateCar():void {
    this.update = !this.update;
  }

  getCar(id:any): void {
    this.carService.getOne(id).subscribe(data => {
      this.car = data;
    });
  }

  onSubmit(): void {
    this.carService.updateCar(this.car.id, this.car.name, this.car.type, this.car.fuel, this.car.consumption, this.car.picture)
    .subscribe(() => {
      this.update = false;
    });
  }

}
