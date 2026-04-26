import { Component, inject } from '@angular/core';
import { AuthService } from '../../core/auth.service';
import { CommonModule } from '@angular/common';
import { effect } from '@angular/core';
@Component({
  selector: 'app-permisos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './permisos.component.html',
  styleUrl: './permisos.component.css'
})
export class PermisosComponent {
  auth = inject(AuthService);

 // permisos = this.auth.permisos; // 👈 ahora es propiedad
}

