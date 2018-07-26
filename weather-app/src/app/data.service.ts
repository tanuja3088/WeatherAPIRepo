import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  url: string;
  constructor(private http: HttpClient) {
    this.url  = 'http://localhost:8080/rest/getData/city?city=';
  }

  search_word(term) {
    return this.http.get(this.url + term);
  }
}
