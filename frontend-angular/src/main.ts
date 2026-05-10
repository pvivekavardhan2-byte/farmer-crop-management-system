import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter, Routes } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { importProvidersFrom } from '@angular/core';

import { AppComponent } from './app/app.component';
import { DashboardComponent } from './app/components/dashboard/dashboard.component';
import { FarmerFormComponent } from './app/components/farmer-form/farmer-form.component';
import { FarmerListComponent } from './app/components/farmer-list/farmer-list.component';
import { CropFormComponent } from './app/components/crop-form/crop-form.component';
import { InvestmentFormComponent } from './app/components/investment-form/investment-form.component';
import { WeatherComponent } from './app/components/weather/weather.component';
import { ReportsComponent } from './app/components/reports/reports.component';

const routes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'farmers/add', component: FarmerFormComponent },
  { path: 'farmers', component: FarmerListComponent },
  { path: 'crops/add', component: CropFormComponent },
  { path: 'investments/add', component: InvestmentFormComponent },
  { path: 'weather', component: WeatherComponent },
  { path: 'reports', component: ReportsComponent }
];

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter(routes),
    provideHttpClient(),
    importProvidersFrom(FormsModule)
  ]
}).catch(err => console.error(err));
