import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-crop-form',
  standalone: true,
  imports: [FormsModule, CommonModule],
  template: `
    <div class="card">
      <h2>Crop Registration</h2>
      <form (ngSubmit)="saveCrop()">
        <label>Select Farmer</label>
        <select [(ngModel)]="farmerId" name="farmerId">
          <option *ngFor="let farmer of farmers" [value]="farmer.id">{{ farmer.farmerName }}</option>
        </select>

        <label>Crop Name</label>
        <input [(ngModel)]="crop.cropName" name="cropName">

        <label>Season</label>
        <input [(ngModel)]="crop.season" name="season">

        <label>Seed Type</label>
        <input [(ngModel)]="crop.seedType" name="seedType">

        <label>Land Area</label>
        <input type="number" [(ngModel)]="crop.landArea" name="landArea">

        <label>Sowing Date</label>
        <input type="date" [(ngModel)]="crop.sowingDate" name="sowingDate">

        <label>Expected Harvest Date</label>
        <input type="date" [(ngModel)]="crop.expectedHarvestDate" name="expectedHarvestDate">

        <label>Expected Yield</label>
        <input type="number" [(ngModel)]="crop.expectedYield" name="expectedYield">

        <button type="submit">Save Crop</button>
      </form>
    </div>
  `
})
export class CropFormComponent implements OnInit {
  farmers: any[] = [];
  farmerId = 1;

  crop = {
    cropName: '',
    season: '',
    seedType: '',
    landArea: 0,
    sowingDate: '',
    expectedHarvestDate: '',
    expectedYield: 0
  };

  constructor(private api: ApiService) {}

  ngOnInit() {
    this.api.getFarmers().subscribe(data => this.farmers = data);
  }

  saveCrop() {
    this.api.saveCrop(this.farmerId, this.crop).subscribe({
      next: () => alert('Crop saved successfully'),
      error: err => alert('Error: ' + JSON.stringify(err.error))
    });
  }
}
