import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Area, AreaService } from '../../../core/services/area.service';

@Component({
  selector: 'app-area',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './area.component.html',
  styleUrl: './area.component.css'
})
export default class AreaComponent implements OnInit {


  areas: Area[] = [];
  mostrarForm: boolean = false;
  areaForm: Area = {
    nombreArea: '', descripcion: '',
    creadoPor: {
      idUsuario: 0
    },
    actualizadoPor: {
      idUsuario: 0
    },
    idArea: 0
  };

  mostrarFormulario(area: Area | null = null) {
    this.areaSeleccionada = area;
    this.mostrarForm = true;
    if (area) {
      this.areaForm = { ...area };
    } else {
      this.areaForm = { idArea: 0,nombreArea: '', descripcion: '', creadoPor: {
        idUsuario: 0
      },
      actualizadoPor: {
        idUsuario: 0
      } 
    };
         // this.cancelarEdicion();
    }
  }

  areaSeleccionada: Area | null = null;

  constructor(private areaService: AreaService) {}

  ngOnInit(): void {
    this.obtenerAreas();
    
  }

  obtenerAreas(): void {
    this.areaService.getAreas().subscribe((data: Area[]) => {
      this.areas = data;
    });
  }

  guardarArea(): void {
    if (this.areaSeleccionada) {
      // Actualizar Prioridad
      this.areaService.actualizarArea(this.areaSeleccionada.idArea!, this.areaForm)
        .subscribe(() => {
          this.obtenerAreas();
          this.cancelarEdicion();
          this.mostrarForm = false; // Ocultar el formulario después de guardar
        });
    } else {
      // Crear Nueva Area
      this.areaService.crearArea(this.areaForm,)
        .subscribe(() => {
          this.obtenerAreas();
          this.cancelarEdicion();
          this.mostrarForm = false; // Ocultar el formulario después de guardar
        });
    }
  }

  editarArea(area: Area): void {
    this.areaSeleccionada = area;
    this.areaForm = { ...area };
  }

  eliminarArea(id: number): void {
    this.areaService.eliminarArea(id)
      .subscribe(() => this.obtenerAreas());
  }

  cancelarEdicion(): void {
    this.areaSeleccionada = null;
    
    this.areaForm = { idArea: 0, nombreArea: '', descripcion: '', creadoPor: {
      idUsuario: 0
    },
    actualizadoPor: {
      idUsuario: 0
    } 
  };
  this.mostrarForm = false; // Ocultar el formulario después de guardar  
}

  
}
