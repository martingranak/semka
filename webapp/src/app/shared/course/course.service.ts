import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class CourseService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8080/course/all');
  }

  getOne(courseId: string): Observable<any> {
    return this.http.post('//localhost:8080/course/one', null, {
      params: {
        'courseId': courseId
      }
    });
  }

  getAllByName(courseName: string): Observable<any> {
    return this.http.get('//localhost:8080/course/name/' + courseName);
  }

  addCourse(courseName: string, courseType: string): Observable<any> {
    return this.http.post('//localhost:8080/course/add', null, {
      params: {
        'courseName': courseName,
        'courseType': courseType,
      }
    });
  }

  updateCourse(courseId: BigInteger, courseName: string, courseType: string) {
    var data = {
      'courseId': courseId,
      'courseName': courseName,
      'courseType': courseType
    }

    this.http.put('//localhost:8080/course/update', data);
  }

  removeCourse(courseId: string) {
    this.http.delete('//localhost:8080/course/remove', {
      params: {
        'courseId': courseId
      }
    });
  }
}
