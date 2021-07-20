import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment as env } from 'src/environments/environment'
import { Observable, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { Airport } from '../models/Airport';
import { Response } from '../models/response';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private apiUrl: string;

  constructor(private http: HttpClient) { 
    this.apiUrl = env.apiUrl+"/api";
  }

  getAllAirports(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/airports`)
      .pipe(
        map(
          (response) => {
            return response.body;
          }
        ),
        catchError(
          (error)=> {
            return throwError(error);
          }
        )
      );
  }

  getTopWaypointsBySid(id: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/topWaypoints/sid/${id}`)
      .pipe(
        map(
          (response) => {
            return response.body.topWaypoints;
          }
        ),
        catchError(
          (error)=> {
            return throwError(error);
          }
        )
      );
  }

  getTopWaypointsByStar(id: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/topWaypoints/star/${id}`)
      .pipe(
        map(
          (response) => {
            return response.body.topWaypoints;
          }
        ),
        catchError(
          (error)=> {
            return throwError(error);
          }
        )
      );
  }
}
