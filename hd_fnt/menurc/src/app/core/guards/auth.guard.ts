import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

export const AuthGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  const router = inject(Router);

  const token = authService.getTokenForGuard();
  if (!token) {
    return router.navigate(['/login']);
  }

  const payload = JSON.parse(atob(token.split('.')[1]));
  const roles = payload.roles;

  // Verificar si el rol del usuario permite el acceso
  let requiredRole: string[] = route.data?.['role'] as string[];

  console.log("pruebaderolesguard",requiredRole);
  console.log("lo ue llega guard",roles)
  if (!Array.isArray(requiredRole)) {
    requiredRole = [requiredRole];
    console.log("si",requiredRole);
  }
  if (!requiredRole || requiredRole.some(role => roles.includes(role))) {
    console.log("no pero lo incluye",requiredRole);
    return true; 
  }
  console.log("no",requiredRole);
  // Redirigir al home si el rol no es permitido
  console.warn('Acceso denegado. Redirigiendo al home...');
  return router.navigate(['/profile'], {
    
    state: { message: 'No tienes permiso para acceder a este recurso.' },
  });
};