import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

export interface EstadoTicket {
  idEstadoTicket: number;
  nombreEstadoTicket: string;
  descripcion: string;
  creadoPor: { idUsuario: number };
  actualizadoPor: { idUsuario: number };
}


@Injectable({
  providedIn: 'root'
})
export class EstadoticketService {
  private apiUrl = 'http://localhost:8090/api/estados-tkt'; // URL de la API de prioridades

  constructor(private http: HttpClient) {}

  // Obtener todos los EstadoTicket
  getEstadoTickets(): Observable<EstadoTicket[]> {
    return this.http.get<EstadoTicket[]>(`${this.apiUrl}`);
  }

  // Obtener un EstadoTicket por ID
  getEstadoTicketById(id: number): Observable<EstadoTicket> {
    return this.http.get<EstadoTicket>(`${this.apiUrl}/${id}`);
  }

  // Crear un nuevo EstadoTicket
  crearEstadoTicket(estadoTicket: EstadoTicket): Observable<EstadoTicket> {
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
  
    return this.http.post<EstadoTicket>(this.apiUrl, estadoTicket, { headers }).pipe(
      catchError(err => {
        console.error('Error al crear la prioridad:', err);
        return throwError(() => new Error('Error en la solicitud'));
      })
    );
  }
  

  // Actualizar un EstadoTicket existente
  actualizarEstadoTicket(id: number, estadoTicket: EstadoTicket): Observable<EstadoTicket> {
    return this.http.put<EstadoTicket>(`${this.apiUrl}/${id}`, estadoTicket);
  }

  // Eliminar un EstadoTicket por ID
  eliminarEstadoTicket(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
