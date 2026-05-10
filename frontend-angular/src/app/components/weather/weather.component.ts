import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-weather',
  standalone: true,
  imports: [FormsModule, CommonModule],
  template: `
    <div class="card">
      <h2>Weather Forecast</h2>

      <label>City</label>
      <input [(ngModel)]="city" name="city">
      <button (click)="loadWeather()">Get Weather</button>

      <div *ngIf="weather" class="card">
        <h2>{{ weather.city }}</h2>
        <h1>{{ weather.temperature }}°C</h1>
        <p>Condition: {{ weather.condition }}</p>
        <p>Humidity: {{ weather.humidity }}%</p>
        <p>Wind Speed: {{ weather.windSpeed }} km/h</p>
        <p>Rain Chance: {{ weather.rainChance }}%</p>
      </div>
    </div>
  `
})
export class WeatherComponent {
  city = 'Bellary';
  weather: any;

  constructor(private api: ApiService) {
    this.loadWeather();
  }

  loadWeather() {
    this.api.getWeather(this.city).subscribe(data => this.weather = data);
  }
}
