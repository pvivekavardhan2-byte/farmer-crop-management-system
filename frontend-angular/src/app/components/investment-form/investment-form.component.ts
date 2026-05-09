import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-investment-form',
  standalone: true,
  imports: [FormsModule, CommonModule],
  template: `
    <div class="card">
      <h2>Investment Entry</h2>
      <form (ngSubmit)="saveInvestment()">
        <label>Select Crop</label>
        <select [(ngModel)]="cropId" name="cropId">
          <option *ngFor="let crop of crops" [value]="crop.id">{{ crop.cropName }}</option>
        </select>

        <label>Seed Cost</label>
        <input type="number" [(ngModel)]="investment.seedCost" name="seedCost">

        <label>Fertilizer Cost</label>
        <input type="number" [(ngModel)]="investment.fertilizerCost" name="fertilizerCost">

        <label>Pesticide Cost</label>
        <input type="number" [(ngModel)]="investment.pesticideCost" name="pesticideCost">

        <label>Labour Cost</label>
        <input type="number" [(ngModel)]="investment.labourCost" name="labourCost">

        <label>Water Cost</label>
        <input type="number" [(ngModel)]="investment.waterCost" name="waterCost">

        <label>Transport Cost</label>
        <input type="number" [(ngModel)]="investment.transportCost" name="transportCost">

        <label>Machinery Cost</label>
        <input type="number" [(ngModel)]="investment.machineryCost" name="machineryCost">

        <label>Other Cost</label>
        <input type="number" [(ngModel)]="investment.otherCost" name="otherCost">

        <h3>Total: ₹ {{ total() }}</h3>
        <button type="submit">Save Investment</button>
      </form>
    </div>
  `
})
export class InvestmentFormComponent implements OnInit {
  crops: any[] = [];
  cropId = 1;

  investment = {
    seedCost: 0,
    fertilizerCost: 0,
    pesticideCost: 0,
    labourCost: 0,
    waterCost: 0,
    transportCost: 0,
    machineryCost: 0,
    otherCost: 0
  };

  constructor(private api: ApiService) {}

  ngOnInit() {
    this.api.getCrops().subscribe(data => this.crops = data);
  }

  total() {
    return Object.values(this.investment).reduce((sum, value) => sum + Number(value || 0), 0);
  }

  saveInvestment() {
    this.api.saveInvestment(this.cropId, this.investment).subscribe({
      next: () => alert('Investment saved successfully'),
      error: err => alert('Error: ' + JSON.stringify(err.error))
    });
  }
}
