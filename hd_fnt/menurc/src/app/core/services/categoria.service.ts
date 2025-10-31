import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

export interface Categoria {
  idCategoria: number;
  nombreCategoria: string;
  descripcion: string;
  categoriaPadre: number;
  creadoPor: { idUsuario: number };
  actualizadoPor: { idUsuario: number };
}
 
@Injectable({
  providedIn: 'root'
})
export class CategoriaService {
  private apiUrl = 'http://localhost:8090/api/v3/helpdesk/admin/categorias'; // URL de la API de categorias

  constructor(private http: HttpClient) {}

  // Obtener todas las Categoria
  getCategorias(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>(`${this.apiUrl}`);
  }

  // Obtener una Categoria por ID
  getCategoriaById(id: number): Observable<Categoria> {
    return this.http.get<Categoria>(`${this.apiUrl}/${id}`);
  }

  // Crear una nueva Categoria
  crearCategoria(categoria: Categoria): Observable<Categoria> {
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
  
    return this.http.post<Categoria>(this.apiUrl, categoria, { headers }).pipe(
      catchError(err => {
        console.error('Error al crear la prioridad:', err);
        return throwError(() => new Error('Error en la solicitud'));
      })
    );
  }
  

  // Actualizar una Categoria existente
  actualizarCategoria(id: number, categoria: Categoria): Observable<Categoria> {
    return this.http.put<Categoria>(`${this.apiUrl}/${id}`, categoria);
  }

  // Eliminar una Categoria por ID
  eliminarCategoria(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
