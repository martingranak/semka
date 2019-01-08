import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class PaymentService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8080/payment/all');
  }

  getReport(date: string): Observable<any> {
    return this.http.get('//localhost:8080/payment/report/month/' + date);
  }
  getOne(paymentId: string): Observable<any> {
    return this.http.post('//localhost:8080/payment/one', null, {
      params: {
        'paymentId': paymentId
      }
    });
  }

  getAllByRide(rideId: string): Observable<any> {
    return this.http.post('//localhost:8080/payment/ride', null, {
      params: {
        'rideId': rideId
      }
    });
  }

  getAllByDescription(description: string): Observable<any> {
    return this.http.get('//localhost:8080/payment/description/' + description);
  }

  addPayment(rideId: string, value: string, description: string): Observable<any> {
    return this.http.post('//localhost:8080/payment/add', null, {
      params: {
        'rideId': rideId,
        'value': value,
        'description': description
      }
    });
  }

  updatePayment(payment: number, rideId: number, value: number, description: string) {
    var data = {
      'payment': payment,
      'rideId': rideId,
      'value': value,
      'description': description
    }

    this.http.put('//localhost:8080/payment/update', data);
  }

  removePayment(paymentId: string) {
    this.http.delete('//localhost:8080/payment/remove', {
      params: {
        'paymentId': paymentId
      }
    });
  }
}
