import { CommonModule } from '@angular/common';
import { EstadoTicket, EstadoticketService } from '../../../core/services/estadoticket.service';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-estadoticket',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './estadoticket.component.html',
  styleUrl: './estadoticket.component.css'
})
export default class EstadoticketComponent  implements OnInit {
  estadoticket: EstadoTicket[] = [];
  estadoticketSeleccionada: EstadoTicket | null = null;
  mostrarForm = false;
  estadoticketForm: Partial<EstadoTicket> = {
    idEstadoTicket: 0,
    nombreEstadoTicket: '',
    descripcion: ''
  };

  constructor(private estadoticketService: EstadoticketService) {}

  ngOnInit(): void {
    this.obtenerEstadoTicket();
  }

  obtenerEstadoTicket(): void {
    this.estadoticketService.getEstadoTickets().subscribe({
      next: (estadoticket) => {
        this.estadoticket = estadoticket;
      },
      error: (err) => {
        console.error('Error al obtener las categorías:', err);
      }
    });
  }

  mostrarFormulario(estadoticket?: EstadoTicket): void {
    this.mostrarForm = true;
    if (estadoticket) {
      this.estadoticketSeleccionada = estadoticket;
      this.estadoticketForm = { ...estadoticket };
    } else {
      this.estadoticketSeleccionada = null;
      this.estadoticketForm = {
        idEstadoTicket: 0,
        nombreEstadoTicket: '',
        descripcion: ''
      };
    }
  }

  guardarEstadoTicket(): void {
    if (this.estadoticketSeleccionada) {
      // Editar categoría
      this.estadoticketService.actualizarEstadoTicket(this.estadoticketSeleccionada.idEstadoTicket, this.estadoticketForm as EstadoTicket).subscribe({
        next: () => {
          this.obtenerEstadoTicket();
          this.cancelarEdicion();
        },
        error: (err) => {
          console.error('Error al actualizar la categoría:', err);
        }
      });
    } else {
      // Crear nueva categoría
      this.estadoticketService.crearEstadoTicket(this.estadoticketForm as EstadoTicket).subscribe({
        next: () => {
          this.obtenerEstadoTicket();
          this.cancelarEdicion();
        },
        error: (err) => {
          console.error('Error al crear la categoría:', err);
        }
      });
    }
  }

  eliminarEstadoTicket(idEstadoTicket: number): void {
    this.estadoticketService.eliminarEstadoTicket(idEstadoTicket).subscribe({
      next: () => {
        this.obtenerEstadoTicket();
      },
      error: (err) => {
        console.error('Error al eliminar la categoría:', err);
      }
    });
  }

  cancelarEdicion(): void {
    this.mostrarForm = false;
    this.estadoticketSeleccionada = null;
    this.estadoticketForm = {
      idEstadoTicket: 0,
      nombreEstadoTicket: '',
      descripcion: ''
    };
  }
}