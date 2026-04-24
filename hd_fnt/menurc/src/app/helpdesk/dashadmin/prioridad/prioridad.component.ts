import { Component, OnInit } from '@angular/core';
import { Prioridad, PrioridadService } from '../../../core/services/prioridad.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({ 
  selector: 'app-prioridad',
  standalone: true,
  imports: [FormsModule,CommonModule,HttpClientModule],
  templateUrl: './prioridad.component.html',
  styleUrl: './prioridad.component.css'
})
export default class PrioridadComponent implements OnInit {


  prioridades: Prioridad[] = [];
  mostrarForm: boolean = false;
  prioridadForm: Prioridad = {
    nombrePrioridad: '', descripcion: '', nivel: 0,
    creadoPor: {
      idUsuario: 0
    },
    actualizadoPor: {
      idUsuario: 0
    },
    idPrioridad: 0
  };

  mostrarFormulario(prioridad: Prioridad | null = null) {
    this.prioridadSeleccionada = prioridad;
    this.mostrarForm = true;
    if (prioridad) {
      this.prioridadForm = { ...prioridad };
    } else {
      this.prioridadForm = { idPrioridad: 0,nombrePrioridad: '', descripcion: '', nivel: 0, creadoPor: {
        idUsuario: 0
      },
      actualizadoPor: {
        idUsuario: 0
      } 
    };
         // this.cancelarEdicion();
    }
  }

  prioridadSeleccionada: Prioridad | null = null;

  constructor(private prioridadService: PrioridadService) {}

  ngOnInit(): void {
    this.obtenerPrioridades();
    
  }

  obtenerPrioridades(): void {
    this.prioridadService.getPrioridades().subscribe((data: Prioridad[]) => {
      this.prioridades = data;
    });
  }

  guardarPrioridad(): void {
    if (this.prioridadSeleccionada) {
      // Actualizar Prioridad
      this.prioridadService.actualizarPrioridad(this.prioridadSeleccionada.idPrioridad!, this.prioridadForm)
        .subscribe(() => {
          this.obtenerPrioridades();
          this.cancelarEdicion();
          this.mostrarForm = false; // Ocultar el formulario después de guardar
        });
    } else {
      // Crear Nueva Prioridad
      this.prioridadService.crearPrioridad(this.prioridadForm)
        .subscribe(() => {
          this.obtenerPrioridades();
          this.cancelarEdicion();
          this.mostrarForm = false; // Ocultar el formulario después de guardar
        });
    }
  }

  editarPrioridad(prioridad: Prioridad): void {
    this.prioridadSeleccionada = prioridad;
    this.prioridadForm = { ...prioridad };
  }

  eliminarPrioridad(id: number): void {
    this.prioridadService.eliminarPrioridad(id)
      .subscribe(() => this.obtenerPrioridades());
  }

  cancelarEdicion(): void {
    this.prioridadSeleccionada = null;
    
    this.prioridadForm = { idPrioridad: 0, nombrePrioridad: '', descripcion: '', nivel: 0, creadoPor: {
      idUsuario: 0
    },
    actualizadoPor: {
      idUsuario: 0
    } 
  };
  this.mostrarForm = false; // Ocultar el formulario después de guardar  
}

  
}
