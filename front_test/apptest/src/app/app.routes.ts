import { Routes } from '@angular/router';
import { FormComponent } from './features/form/form.component';
import { PermisosComponent } from './permisos/permisos/permisos.component';

export const routes: Routes = [

  { path: '', component: FormComponent },
  { path: 'permisos', component: PermisosComponent }
    
];
