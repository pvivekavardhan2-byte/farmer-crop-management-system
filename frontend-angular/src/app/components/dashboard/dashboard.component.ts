import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [RouterLink],
  template: `
    <h1>Dashboard</h1>
    <div class="grid">
      <div class="card"><h3>Total Farmers</h3><h2>120</h2></div>
      <div class="card"><h3>Total Crops</h3><h2>78</h2></div>
      <div class="card"><h3>Total Investment</h3><h2>₹25,60,000</h2></div>
      <div class="card"><h3>Profit / Loss</h3><h2>₹6,40,000</h2></div>
    </div>

    <div class="card">
      <h2>Project Flow</h2>
      <p>Add Farmer → Add Crop → Add Investment → Check Weather → Generate Reports</p>
    </div>
  `
})
export class DashboardComponent {}
