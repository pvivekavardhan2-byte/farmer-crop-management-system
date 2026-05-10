import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ApiService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getFarmers(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/farmers`);
  }

  saveFarmer(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/farmers`, data);
  }

  deleteFarmer(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/farmers/${id}`, { responseType: 'text' });
  }

  saveCrop(farmerId: number, data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/crops/farmer/${farmerId}`, data);
  }

  getCrops(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/crops`);
  }

  saveInvestment(cropId: number, data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/investments/crop/${cropId}`, data);
  }

  getWeather(city: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/weather/current?city=${city}`);
  }

  getReports(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/reports/profit-loss`);
  }
}
