import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterLink],
  template: `
    <header class="header">
      <nav>
        <a routerLink="/">Home</a>
        <a routerLink="/add">Add Todo</a>
      </nav>
    </header>
  `,
  styles: [`
    .header {
      background-color: #333;
      padding: 1rem;
      nav {
        display: flex;
        gap: 1rem;
        a {
          color: white;
          text-decoration: none;
          &:hover {
            color: #ddd;
          }
        }
      }
    }
  `]
})
export class HeaderComponent {} 