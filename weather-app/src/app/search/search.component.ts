import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { DataService } from '../service/data.service';
import { WeatherService } from '../service/weather.service';
import { Weather } from '../model/weather.model';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {
  searchTerm: FormControl = new FormControl();
  searchResult:  string[] = [];
  selectedValue: string;
  weatherInfo: Weather[] = [];

  constructor(private service: DataService, private weatherService: WeatherService) {
    this.searchTerm.valueChanges.subscribe(data => {
        this.service.search_word(data).subscribe(response => {
          this.searchResult = response;
        });
      });
  }

  valueMapper = (key) => {
    const selection = this.searchResult.find(function(searchResult) {
      return searchResult === key;
    });
    if (selection) {
      this.selectedValue = selection;
      return this.selectedValue;
    }
  }


  addWeatherInfo() {
    let isNewWeatherLocation = true;
    this.weatherService.get_weather(this.selectedValue).subscribe(response => {
      this.weatherInfo.forEach(function(weather) {
        if (weather.location.name === response.location.name) {
          isNewWeatherLocation = false;
        }
      });
      console.log('isNewWeatherLocation: ', isNewWeatherLocation);
      if (isNewWeatherLocation) {
        this.weatherInfo.push(response);
      }
      console.log('This weatherInfo: ', this.weatherInfo);
    });
    this.searchTerm.reset();
  }

  removeEntry(i: number) {
    console.log('index: ', i);
    this.weatherInfo.splice(i, 1);
   console.log('weatherInfo: ', this.weatherInfo);
  }
}

