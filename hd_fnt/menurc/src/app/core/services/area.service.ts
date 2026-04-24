import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

export interface Area {
  idArea: number;
  nombreArea: string;
  descripcion: string;
  creadoPor: { idUsuario: number };
  actualizadoPor: { idUsuario: number };
}

@Injectable({
  providedIn: 'root'
})
export class AreaService {
  private apiUrl = 'http://localhost:8090/api/areas'; // URL de la API de prioridades

  constructor(private http: HttpClient) {}

  // Obtener todas las areas
  getAreas(): Observable<Area[]> {
    return this.http.get<Area[]>(`${this.apiUrl}`);
  }

  // Obtener una area por ID
  getAreaById(id: number): Observable<Area> {
    return this.http.get<Area>(`${this.apiUrl}/${id}`);
  }

  // Crear una nueva area
  crearArea(area: Area): Observable<Area> {
    const token = localStorage.getItem('authToken') ;
    if (!token) {
      console.error('Token no encontrado');
      return throwError(() => new Error('Token no válido o no encontrado'));
    }
  
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
      'Content-Type': 'application/json'
    });
  
    console.log('Headers:', headers);
    console.log('URL API:', this.apiUrl);
  
    return this.http.post<Area>(this.apiUrl, area, { headers }).pipe(
      catchError(err => {
        console.error('Error al crear la prioridad:', err);
        return throwError(() => new Error('Error en la solicitud'));
      })
    );
  }
  

  // Actualizar una area existente
  actualizarArea(id: number, area: Area): Observable<Area> {
    return this.http.put<Area>(`${this.apiUrl}/${id}`, area);
  }

  // Eliminar una area por ID
  eliminarArea(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
