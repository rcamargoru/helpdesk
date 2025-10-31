import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Ticket, TicketService } from '../../core/services/ticket.service';

@Component({ 
  selector: 'app-dashboard',
  standalone: true,
  imports: [FormsModule,CommonModule,ReactiveFormsModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export default class DashboardComponent implements OnInit {
  tickets: Ticket[] = [];
  ticketSeleccionada: Ticket | null = null;
  mostrarForm = false;
  ticketForm: Partial<Ticket> = {
    idTicket: 0,
    titulo: '',
    descripcion: '',
    usuarioCreador: { idUsuario: 0},
    agente: { idUsuario: 0},
    categoria: { idCategoria: 0},
    area: { idArea: 0},
    estado: 1,
    prioridad:{ idPrioridad: 0},
    creadoPor: { idUsuario: 0},
    actualizadoPor: { idUsuario: 0}
  };
  
  mostrarFormulario(ticket?: Ticket): void {
    this.mostrarForm = true;
    if (ticket) {
      this.ticketSeleccionada = ticket;
      this.ticketForm = { ...ticket };
    } else {
      this.ticketSeleccionada = null;
      this.ticketForm = {
        idTicket: 0,
        titulo: '',
        descripcion: '',
        usuarioCreador: { idUsuario: 0},
        agente: { idUsuario: 0},
        categoria: { idCategoria: 0},
        area: { idArea: 0},
        estado: 1,
        prioridad:{ idPrioridad: 0},
        creadoPor: { idUsuario: 0},
        actualizadoPor: { idUsuario: 0}
      };
    }
  }
  constructor(private ticketService: TicketService) {}

  ngOnInit(): void {
    this.obtenerTicket();
  }


  obtenerTicket(): void {
    this.ticketService.getTickets().subscribe({
      next: (ticket) => {
        this.tickets = ticket;
      },
      error: (err) => {
        console.error('Error al obtener las categorías:', err);
      }
    });
  }



  guardarTicket(): void {
    if (this.ticketSeleccionada) {
      // Editar categoría
      this.ticketService.actualizarTicket(this.ticketSeleccionada.idTicket, this.ticketForm as Ticket).subscribe({
        next: () => {
          this.obtenerTicket();
          this.cancelarEdicion();
        },
        error: (err) => {
          console.error('Error al actualizar la categoría:', err);
        }
      });
    } else {
      // Crear nueva categoría
      this.ticketService.crearTicket(this.ticketForm as Ticket).subscribe({
        next: () => {
          this.obtenerTicket();
          this.cancelarEdicion();
        },
        error: (err) => {
          console.error('Error al crear la categoría:', err);
        }
      });
    }
  }

  eliminarEstadoTicket(idEstadoTicket: number): void {
    this.ticketService.eliminarTicket(idEstadoTicket)
  }

  cancelarEdicion(): void {
    this.mostrarForm = false;
    this.ticketSeleccionada = null;
    this.ticketForm = {
      idTicket: 0,
      titulo: '',
      descripcion: '',
      usuarioCreador: { idUsuario: 0},
      agente: { idUsuario: 0},
      categoria: { idCategoria: 0},
      area: { idArea: 0},
      estado: 1,
      prioridad:{ idPrioridad: 0},
      creadoPor: { idUsuario: 0},
      actualizadoPor: { idUsuario: 0}
    };
  }
}