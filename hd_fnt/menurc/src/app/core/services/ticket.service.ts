import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

export interface Ticket {
  idTicket: number;
  titulo: string;
  descripcion: string;
  usuarioCreador: { idUsuario: number };
  agente: { idUsuario: number };
  categoria: { idCategoria: number };
  area: { idArea: number };
  estado:1;
  prioridad: { idPrioridad: number };
  creadoPor: { idUsuario: number };
  actualizadoPor: { idUsuario: number };
}


@Injectable({
  providedIn: 'root'
})
export class TicketService {
  private apiUrl = 'http://localhost:8090/api/v3/helpdesk/tickets'; // URL de la API de prioridades

  constructor(private http: HttpClient) {}

  // Obtener todas los Ticket
  getTickets(): Observable<Ticket[]> {
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
  
    return this.http.get<Ticket[]>(this.apiUrl, { headers }).pipe(
      catchError(err => {
        console.error('Error al crear la prioridad:', err);
        return throwError(() => new Error('Error en la solicitud'));
      })
    );
    //return this.http.get<Ticket[]>(`${this.apiUrl}`);
  }

  // Obtener un Ticket por ID
  getTicketById(id: number): Observable<Ticket> {
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
  
    return this.http.post<Ticket>(`${this.apiUrl}/${id}`, { headers }).pipe(
      catchError(err => {
        console.error('Error al crear la prioridad:', err);
        return throwError(() => new Error('Error en la solicitud'));
      })
    );
    //return this.http.get<Ticket>(`${this.apiUrl}/${id}`);
  }

  // Crear un Ticket
  crearTicket(ticket: Ticket): Observable<Ticket> {
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
  
    return this.http.post<Ticket>(this.apiUrl, ticket, { headers }).pipe(
      catchError(err => {
        console.error('Error al crear la prioridad:', err);
        return throwError(() => new Error('Error en la solicitud'));
      })
    );
  }
  

  // Actualizar un Ticket existente
  actualizarTicket(id: number, ticket: Ticket): Observable<Ticket> {
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
  
    return this.http.post<Ticket>(`${this.apiUrl}/${id}`, ticket, { headers }).pipe(
      catchError(err => {
        console.error('Error al crear la prioridad:', err);
        return throwError(() => new Error('Error en la solicitud'));
      })
    );
   //return this.http.put<Ticket>(`${this.apiUrl}/${id}`, ticket);
  }

  // Eliminar un Ticket 
  eliminarTicket(id: number): void {
    //return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
