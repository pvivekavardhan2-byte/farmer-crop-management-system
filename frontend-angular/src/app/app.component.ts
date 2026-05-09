import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink],
  template: `
    <div class="layout">
      <aside class="sidebar">
        <h2>🌱 FCIS</h2>
        <a routerLink="/">Dashboard</a>
        <a routerLink="/farmers/add">Add Farmer</a>
        <a routerLink="/farmers">Farmer List</a>
        <a routerLink="/crops/add">Add Crop</a>
        <a routerLink="/investments/add">Investment</a>
        <a routerLink="/weather">Weather</a>
        <a routerLink="/reports">Reports</a>
      </aside>

      <main class="content">
        <router-outlet></router-outlet>
      </main>
    </div>
  `
})
export class AppComponent {}
