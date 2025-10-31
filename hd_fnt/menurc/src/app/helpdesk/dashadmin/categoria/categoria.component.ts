import { Component, OnInit } from '@angular/core';
import { Categoria, CategoriaService } from '../../../core/services/categoria.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({ 
  selector: 'app-categoria',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './categoria.component.html',
  styleUrl: './categoria.component.css'
})
export default class CategoriaComponent implements OnInit {
  categorias: Categoria[] = [];
  categoriaSeleccionada: Categoria | null = null;
  mostrarForm = false;
  categoriaForm: Partial<Categoria> = {
    idCategoria: 0,
    nombreCategoria: '',
    descripcion: '',
    categoriaPadre: 0
  };

  constructor(private categoriaService: CategoriaService) {}

  ngOnInit(): void {
    this.obtenerCategorias();
  }

  obtenerCategorias(): void {
    this.categoriaService.getCategorias().subscribe({
      next: (categorias) => {
        this.categorias = categorias;
      },
      error: (err) => {
        console.error('Error al obtener las categorías:', err);
      }
    });
  }

  mostrarFormulario(categoria?: Categoria): void {
    this.mostrarForm = true;
    if (categoria) {
      this.categoriaSeleccionada = categoria;
      this.categoriaForm = { ...categoria };
    } else {
      this.categoriaSeleccionada = null;
      this.categoriaForm = {
        idCategoria: 0,
        nombreCategoria: '',
        descripcion: '',
        categoriaPadre: 0
      };
    }
  }

  guardarCategoria(): void {
    if (this.categoriaSeleccionada) {
      // Editar categoría
      this.categoriaService.actualizarCategoria(this.categoriaSeleccionada.idCategoria, this.categoriaForm as Categoria).subscribe({
        next: () => {
          this.obtenerCategorias();
          this.cancelarEdicion();
        },
        error: (err) => {
          console.error('Error al actualizar la categoría:', err);
        }
      });
    } else {
      // Crear nueva categoría
      this.categoriaService.crearCategoria(this.categoriaForm as Categoria).subscribe({
        next: () => {
          this.obtenerCategorias();
          this.cancelarEdicion();
        },
        error: (err) => {
          console.error('Error al crear la categoría:', err);
        }
      });
    }
  }

  eliminarCategoria(idCategoria: number): void {
    this.categoriaService.eliminarCategoria(idCategoria).subscribe({
      next: () => {
        this.obtenerCategorias();
      },
      error: (err) => {
        console.error('Error al eliminar la categoría:', err);
      }
    });
  }

  cancelarEdicion(): void {
    this.mostrarForm = false;
    this.categoriaSeleccionada = null;
    this.categoriaForm = {
      idCategoria: 0,
      nombreCategoria: '',
      descripcion: '',
      categoriaPadre: 0
    };
  }
}