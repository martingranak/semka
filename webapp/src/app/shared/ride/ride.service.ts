import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class RideService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8080/ride/all');
  }

  getOne(rideId: string): Observable<any> {
    return this.http.post('//localhost:8080/ride/one', null, {
      params: {
        'rideId': rideId
      }
    });
  }

  getAllByDriver(driverId: string): Observable<any> {
    return this.http.post('//localhost:8080/ride/driver', null, {
      params: {
        'driverId': driverId
      }
    });
  }

  getAllByCar(carId: string): Observable<any> {
    return this.http.post('//localhost:8080/ride/car', null, {
      params: {
        'carId': carId
      }
    });
  }

  addRide(identityNumber: string, carId: string, dateFrom: string, dateTo: string): Observable<any> {
    return this.http.post('//localhost:8080/ride/add', null, {
      params: {
        'identityNumber': identityNumber,
        'carId': carId,
        'dateFrom': dateFrom,
        'dateTo': dateTo
      }
    });
  }

  updateRide(rideId: number, identityNumber: string, carId: number, dateFrom: string, dateTo: string) {
    var data = {
      'rideId': rideId,
      'identityNumber': identityNumber,
      'carId': carId,
      'dateFrom': dateFrom,
      'dateTo': dateTo
    }

    this.http.put('//localhost:8080/ride/update', data);
  }

  removeRide(rideId: string) {
    this.http.delete('//localhost:8080/ride/remove', {
      params: {
        'rideId': rideId
      }
    });
  }
}
