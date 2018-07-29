import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import {City} from '../model/weather.model';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  url: string;
  constructor(private http: HttpClient) {
    this.url  = 'http://localhost:8080/rest/getData/city?city=';
  }

  search_word(cityName) {
    return this.http.get<City[]>(this.url + cityName);
  }
}
