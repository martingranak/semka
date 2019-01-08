import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class CarService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8080/car/all');
  }

  getAllPaginated(id: any): Observable<any> {
    return this.http.get('//localhost:8080/car/all/' + id);
  }

  getOne(carId: string): Observable<any> {
    return this.http.post('//localhost:8080/car/one', null, {
      params: {
        'carId': carId
      }
    });
  }

  

  getAllByName(carName: string): Observable<any> {
    return this.http.get('//localhost:8080/car/name/' + carName);
  }

  getAllByType(carType: string): Observable<any> {
    return this.http.get('//localhost:8080/car/type/' + carType);
  }

  getAllByFuel(carFuelType:  string): Observable<any> {
    return this.http.get('//localhost:8080/car/fuel/' + carFuelType);
  }

  addCar(carName: string, carType: string, carFuelType: string, carConsumption: string, carPicture: Blob): Observable<any> {
    let formData = new FormData();
    formData.append('carPicture', carPicture);

    return this.http.post('//localhost:8080/car/add', formData, {
      params: {
        'carName': carName,
        'carType': carType,
        'carFuelType': carFuelType,
        'carConsumption': carConsumption
      }
    });
  }

  updateCar(carId: string, carName: string, carType: string, carFuelType: string, carConsumption: string, carPicture: Blob) {
    var data = {
      'carId': carId,
      'carName': carName,
      'carType': carType,
      'carFuelType': carFuelType,
      'carConsumption': carConsumption,
      'carPicture': carPicture
    }

    return this.http.put('//localhost:8080/car/update', data);
  }

  removeCar(carId: string) {
    return this.http.delete('//localhost:8080/car/remove', {
      params: {
        'carId': carId
      }
    });
  }
}
