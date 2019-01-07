import { Component, OnInit } from '@angular/core';
import { CarService } from '../../../shared/car/car.service';
import { Car } from '../../../models/car'
import { Router } from '@angular/router'; 
@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {
  cars: Car[];
  page: number = 1;
  selectedCar: Car;

  constructor(private carService: CarService, private router: Router) { }

  ngOnInit() {
    this.getCars();
  }

  onSelect(car: Car): void {
    this.router.navigate(['/car-view', car.id]);
  }

  getCars(): void {
    this.carService.getAllPaginated(this.page).subscribe(data => {
      this.cars = data;
    });
  }

  decreasePage(): void {
    if(this.page != 1){
      this.page -= 1;
      this.getCars();
    }
  }

  increasePage(): void {
      this.page += 1;
      this.getCars();
  }

  deleteCar(car: Car): void {
    this.carService.removeCar(car.id).subscribe(() => {
      this.getCars();
    });
  }
}
