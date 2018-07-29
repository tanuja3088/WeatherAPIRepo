import {Component, OnInit} from '@angular/core';
import { DataService } from '../service/data.service';
import { WeatherService } from '../service/weather.service';
import {City, Weather} from '../model/weather.model';
import {FormControl, Validators} from '@angular/forms';
import { debounceTime } from 'rxjs/internal/operators';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  searchTerm: FormControl = new FormControl();
  searchResult: City[] = [];
  selectedValue: String;
  weatherInfo: Weather[] = [];
  separator: String = ', ';

  ngOnInit() {
    this.searchTerm.valueChanges.pipe(debounceTime(500)).subscribe(data => {
      console.log('data', data);
      /*
        typeof check is needed to avoid extra API call with Object
       */
      if (typeof data === 'string') {
        this.cityService.search_word(data).subscribe(response => {
          this.searchResult = response;
        });
      }
    });
  }

  constructor(private cityService: DataService, private weatherService: WeatherService) {
  }

  valueMapper = (key) => {
    const selection = this.searchResult.find(function (searchResult) {
      return searchResult === key;
    });
    if (selection) {
      this.selectedValue = selection.cityName;
      return (selection.cityName + this.separator + selection.state);
    }
  }


  addWeatherInfo() {
    let isNewWeatherLocation = true;
    console.log('this.isLoading', this.isLoading);
    this.weatherService.get_weather(this.selectedValue).subscribe(response => {
      this.weatherInfo.forEach(function (weather) {
        if (weather.location.name === response.location.name) {
          isNewWeatherLocation = false;
        }
      });
      console.log('isNewWeatherLocation: ', isNewWeatherLocation);
      if (isNewWeatherLocation) {
        this.setBackgroudColor(response);
        this.weatherInfo.push(response);
      }
      console.log('This weatherInfo: ', this.weatherInfo);
    });
    this.searchTerm.reset();
    this.selectedValue = null;
  }

  removeEntry(i: number) {
    console.log('index: ', i);
    this.weatherInfo.splice(i, 1);
    console.log('weatherInfo: ', this.weatherInfo);
  }

  setBackgroudColor(weather: Weather) {
    const weatherText = weather.current.condition.text;
    if (weatherText === 'Sunny') {
      weather.current.condition.backgroundColor = '#005c99';
    } else if (weatherText.indexOf('rain') > -1 || weatherText.indexOf('drizzle') > -1) {
      weather.current.condition.backgroundColor = '#4db8ff';
    } else if (weatherText.indexOf('cloud') > -1 || weatherText.indexOf('Mist') > -1) {
      weather.current.condition.backgroundColor = '#78786C';
    } else {
      weather.current.condition.backgroundColor = '#80aaff';
    }
  }

  getErrorMessage() {
    return this.searchTerm.hasError('required') ? 'You must enter a value' : '';
  }
}

