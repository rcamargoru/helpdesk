import { Injectable, signal } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  // 🔥 signal real
  permisosSignal = signal<string[]>([]);

  constructor() {
    this.cargarDesdeToken();
  }

  private cargarDesdeToken() {
    const token = localStorage.getItem('token');
    if (!token) return;

    try {
      const payload = JSON.parse(atob(token.split('.')[1]));
      this.permisosSignal.set(payload.permissions || []);
    } catch (e) {
      console.error('Error token', e);
    }
  }

  setToken(token: string) {
    localStorage.setItem('token', token);
    this.cargarDesdeToken();
  }

  hasPermission(permiso: string): boolean {
    return this.permisosSignal().includes(permiso);
  }
}
