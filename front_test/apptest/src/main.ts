import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { RouterOutlet } from '@angular/router';
import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  template: `
    <h1>Mi App</h1>

    <nav>
      <a routerLink="/form">Formulario</a> |
      <a routerLink="/permisos">Permisos</a>
    </nav>

    <hr>

    <router-outlet></router-outlet>
  `
})
class AppComponent {}

bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));
