import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-farmer-list',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="card">
      <h2>Farmer List</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Farmer Name</th>
            <th>Mobile</th>
            <th>Village</th>
            <th>Land Size</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          <tr *ngFor="let farmer of farmers">
            <td>{{ farmer.id }}</td>
            <td>{{ farmer.farmerName }}</td>
            <td>{{ farmer.mobileNumber }}</td>
            <td>{{ farmer.village }}</td>
            <td>{{ farmer.landSize }}</td>
            <td><button class="delete" (click)="deleteFarmer(farmer.id)">Delete</button></td>
          </tr>
        </tbody>
      </table>
    </div>
  `
})
export class FarmerListComponent implements OnInit {
  farmers: any[] = [];

  constructor(private api: ApiService) {}

  ngOnInit() {
    this.loadFarmers();
  }

  loadFarmers() {
    this.api.getFarmers().subscribe(data => this.farmers = data);
  }

  deleteFarmer(id: number) {
    this.api.deleteFarmer(id).subscribe(() => this.loadFarmers());
  }
}
