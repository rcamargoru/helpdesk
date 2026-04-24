import { Routes } from '@angular/router';
import { AuthGuard } from './core/guards/auth.guard';
import { AuthenticatedGuard } from './core/guards/authenticated.guard';

export const routes: Routes = [
    // Ruta principal, redirige al login
    {
      path: '',
      redirectTo: 'login',
      pathMatch: 'full'
    },
    // Ruta para el login, protegida por AuthenticatedGuard
    {
      path: 'login',
      loadComponent: () => import('./helpdesk/authentication/login/login.component'),
      canActivate: [AuthenticatedGuard]
    },
    // Rutas protegidas por AuthGua rd
    {
      path: '',
      loadComponent: () => import('./shared/components/layout/layout.component'),
      children: [
        {
          path: 'dashboard',
          loadComponent: () => import('./helpdesk/dashboard/dashboard.component'),
          canActivate: [AuthGuard], data: { role: ['ROLE_ADMIN', 'ROLE_USER'] } 
        },
        {
          path: 'dashadmin', 
          loadComponent: () => import('./helpdesk/dashadmin/dashadmin.component'),
          canActivate: [AuthGuard], data: { role: ['ROLE_ADMIN'] } 
        },
        {
          path: 'prioridad',
          loadComponent: () => import('./helpdesk/dashadmin/prioridad/prioridad.component'),
          canActivate: [AuthGuard], data: { role: ['ROLE_ADMIN'] } 
        },
        {
          path: 'area',
          loadComponent: () => import('./helpdesk/dashadmin/area/area.component'),
          canActivate: [AuthGuard], data: { role: ['ROLE_ADMIN']} 
        },        {
          path: 'categoria',
          loadComponent: () => import('./helpdesk/dashadmin/categoria/categoria.component'),
          canActivate: [AuthGuard], data: { role: ['ROLE_ADMIN'] } 
        },        {
          path: 'estados-tkt',
          loadComponent: () => import('./helpdesk/dashadmin/estadoticket/estadoticket.component'),
          canActivate: [AuthGuard], data: { role: ['ROLE_ADMIN'] } 
        },
        {
          path: 'profile',
          loadComponent: () => import('./helpdesk/profile/profile.component'),
          canActivate: [AuthGuard],
          data: { role: ['ROLE_ADMIN', 'ROLE_USER'] } 
        },
        {
          path: 'tables',
          loadComponent: () => import('./helpdesk/tables/tables.component'),
          canActivate: [AuthGuard],
          data: { role: ['ROLE_ADMIN', 'ROLE_USER'] } 
        }
      ]
    },
    // Ruta comodín, redirige al login si la ruta no existe
    {
      path: '**',
      redirectTo: 'login',
      pathMatch: 'full'
    }
  ];
