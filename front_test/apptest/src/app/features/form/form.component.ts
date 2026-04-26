import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../core/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {
  data = {
    usuario: '',
    clave: ''
  };
 private router = inject(Router); 
constructor(
  private http: HttpClient,
  private authService: AuthService
) {}

enviar() {
  
  this.http.post<any>('http://localhost:8080/api/v1/auth/login', this.data)
    .subscribe({
      next: res => {

        // 🔥 usar el servicio
        this.authService.setToken(res.accsToken);
        this.router.navigate(['/permisos']);
      }
    });
    
}
}
