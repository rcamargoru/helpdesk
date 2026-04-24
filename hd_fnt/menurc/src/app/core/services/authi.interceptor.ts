  import { HTTP_INTERCEPTORS, HttpClientModule, HttpInterceptorFn } from '@angular/common/http';
import { Component } from '@angular/core';

  export const authiInterceptor: HttpInterceptorFn = (req, next) => {

    const token = localStorage.getItem('authToken');
    if (token) {
      console.log("Token antes: "+token);
      const clonedRequest = req.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`  // Incluir el token en el encabezado Authorization
        }
      });
      return next(clonedRequest);  // Continuar con la solicitud modificada
    }
  
    return next(req);
  };