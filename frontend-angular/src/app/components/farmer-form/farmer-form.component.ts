import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-farmer-form',
  standalone: true,
  imports: [FormsModule],
  template: `
    <div class="card">
      <h2>Farmer Registration</h2>
      <form (ngSubmit)="saveFarmer()">
        <label>Farmer Name</label>
        <input [(ngModel)]="farmer.farmerName" name="farmerName" required>

        <label>Mobile Number</label>
        <input [(ngModel)]="farmer.mobileNumber" name="mobileNumber" required>

        <label>Village</label>
        <input [(ngModel)]="farmer.village" name="village" required>

        <label>District</label>
        <input [(ngModel)]="farmer.district" name="district">

        <label>State</label>
        <input [(ngModel)]="farmer.state" name="state">

        <label>Land Size</label>
        <input type="number" [(ngModel)]="farmer.landSize" name="landSize">

        <button type="submit">Save Farmer</button>
      </form>
    </div>
  `
})
export class FarmerFormComponent {
  farmer = {
    farmerName: '',
    mobileNumber: '',
    village: '',
    district: '',
    state: '',
    landSize: 0
  };

  constructor(private api: ApiService) {}

  saveFarmer() {
    this.api.saveFarmer(this.farmer).subscribe({
      next: () => alert('Farmer saved successfully'),
      error: err => alert('Error: ' + JSON.stringify(err.error))
    });
  }
}
