import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class LocationService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8080/location/all');
  }

  getOne(locationId: string): Observable<any> {
    return this.http.post('//localhost:8080/location/one', null, {
      params: {
        'locationId': locationId
      }
    });
  }

  getAllByRide(rideId: string): Observable<any> {
    return this.http.post('//localhost:8080/location/ride/', null, {
      params: {
        'rideId': rideId
      }
    });
  }

  addLocation(rideId: string, latitude: string, longitude: string, date: string): Observable<any> {
    return this.http.post('//localhost:8080/location/add', null, {
      params: {
        'rideId': rideId,
        'latitude': latitude,
        'longitude': longitude,
        'date': date
      }
    });
  }

  updateLocation(locationId: BigInteger, rideId: string, latitude: string, longitude: string, date: string) {
    var data = {
      'locationId': locationId,
      'rideId': rideId,
      'latitude': latitude,
      'longitude': longitude,
      'date': date
    }

    this.http.put('//localhost:8080/location/update', data);
  }

  removeLocation(locationId: string) {
    this.http.delete('//localhost:8080/location/remove', {
      params: {
        'locationId': locationId
      }
    });
  }
}
