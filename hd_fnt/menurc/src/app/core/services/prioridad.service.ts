import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

export interface Prioridad {
  idPrioridad: number;
  nombrePrioridad: string;
  descripcion: string;
  nivel: number;
  creadoPor: { idUsuario: number };
  actualizadoPor: { idUsuario: number };
}
 
@Injectable({
  providedIn: 'root'
})
export class PrioridadService {
  private apiUrl = 'http://localhost:8090/api/v3/helpdesk/admin/prioridades'; // URL de la API de prioridades

  constructor(private http: HttpClient) {}

  // Obtener todas las prioridades
  getPrioridades(): Observable<Prioridad[]> {
    const token = localStorage.getItem('authToken') ;
    if (!token) {
      console.error('Token no encontrado');
      return throwError(() => new Error('Token no válido o no encontrado'));
    }
  
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });
  
    console.log('Headers: pri3', headers);
    console.log('URL API pri3:', this.apiUrl);
  
    return this.http.get<Prioridad[]>(this.apiUrl, { headers }).pipe(
      catchError(err => {
        console.error('Error al crear la prioridad:', err);
        return throwError(() => new Error('Error en la solicitud'));
      })
    );
   // return this.http.get<Prioridad[]>(`${this.apiUrl}`);
  }

  // Obtener una prioridad por ID
  getPrioridadById(id: number): Observable<Prioridad> {
    const token = localStorage.getItem('authToken') ;
    if (!token) {
      console.error('Token no encontrado');
      return throwError(() => new Error('Token no válido o no encontrado'));
    }
  
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });
  
    return this.http.get<Prioridad>(`${this.apiUrl}/${id}`, { headers }).pipe(
      catchError(err => {
        console.error('Error al crear la prioridad:', err);
        return throwError(() => new Error('Error en la solicitud'));
      })
    );
    //return this.http.get<Prioridad>(`${this.apiUrl}/${id}`);
  }

  // Crear una nueva prioridad
  crearPrioridad(prioridad: Prioridad): Observable<Prioridad> {
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
  
    return this.http.post<Prioridad>(this.apiUrl, prioridad, { headers }).pipe(
      catchError(err => {
        console.error('Error al crear la prioridad:', err);
        return throwError(() => new Error('Error en la solicitud'));
      })
    );
  }
  

  // Actualizar una prioridad existente
  actualizarPrioridad(id: number, prioridad: Prioridad): Observable<Prioridad> {
    const token = localStorage.getItem('authToken') ;
    if (!token) {
      console.error('Token no encontrado');
      return throwError(() => new Error('Token no válido o no encontrado'));
    }
  
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });
  
  
    return this.http.put<Prioridad>(`${this.apiUrl}/${id}`, prioridad, { headers }).pipe(
      catchError(err => {
        console.error('Error al crear la prioridad:', err);
        return throwError(() => new Error('Error en la solicitud'));
      })
    );
    //return this.http.put<Prioridad>(`${this.apiUrl}/${id}`, prioridad);
  }

  // Eliminar una prioridad por ID
  eliminarPrioridad(id: number): Observable<void> {
    const token = localStorage.getItem('authToken') ;
    if (!token) {
      console.error('Token no encontrado');
      return throwError(() => new Error('Token no válido o no encontrado'));
    }
  
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });
  
    console.log('Headers: pri3', headers);
    console.log('URL API pri3:', this.apiUrl);
  
    return this.http.delete<void>(`${this.apiUrl}/${id}`, { headers }).pipe(
      catchError(err => {
        console.error('Error al crear la prioridad:', err);
        return throwError(() => new Error('Error en la solicitud'));
      })
    );
    //return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
