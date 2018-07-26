import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  url: string;
  constructor(private http: HttpClient) {
    this.url  = 'http://localhost:8080/rest/getData/weather?city=';
  }

  get_weather(city) {
    return this.http.get(this.url + city);
  }
}
