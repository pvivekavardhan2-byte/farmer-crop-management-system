import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-reports',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="card">
      <h2>Profit / Loss Report</h2>
      <table>
        <thead>
          <tr>
            <th>Farmer</th>
            <th>Crop</th>
            <th>Investment</th>
            <th>Expected Revenue</th>
            <th>Profit/Loss</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          <tr *ngFor="let report of reports">
            <td>{{ report.farmerName }}</td>
            <td>{{ report.cropName }}</td>
            <td>{{ report.investment }}</td>
            <td>{{ report.expectedRevenue }}</td>
            <td>{{ report.profitOrLoss }}</td>
            <td [class.profit]="report.status === 'Profit'" [class.loss]="report.status === 'Loss'">
              {{ report.status }}
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  `
})
export class ReportsComponent implements OnInit {
  reports: any[] = [];

  constructor(private api: ApiService) {}

  ngOnInit() {
    this.api.getReports().subscribe(data => this.reports = data);
  }
}
