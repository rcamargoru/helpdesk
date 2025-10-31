package com.jr.jr.helpDesk.service;

import com.jr.jr.helpDesk.model.Categoria;
import com.jr.jr.helpDesk.model.Usuario;
import com.jr.jr.helpDesk.repository.CategoriaRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CategoriaService {

    private final WebClient webClient;

    @Autowired
    public CategoriaService(WebClient categoriaService) {
        this.webClient = categoriaService;
    }

    @Autowired
    private CategoriaRepo categoriaRepository;

    public Usuario obtenerUsuarioPorNombre(String nombre, String tokenJwt) {
        try {
            return webClient.get()
                    .uri("/api/v3/auth/listarn/{nombre}", nombre)
                    .headers(headers -> headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + tokenJwt))
                    .retrieve()
                    .bodyToMono(Usuario.class)
                    .block();
        } catch (Exception e) {
            System.err.println("Error al obtener el usuario: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Crear una categoría
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Obtener todas las categorías
    public List<Categoria> obtenerCategorias() {
        return categoriaRepository.findAll();
    }

    // Obtener categoría por ID
    public Categoria obtenerCategoria(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }

    // Obtener subcategorías de una categoría específica
    public List<Categoria> obtenerSubcategorias(Long categoriaPadre) {
        return categoriaRepository.findByCategoriaPadre(categoriaPadre);
    }

    // Actualizar una categoría existente
    public Categoria actualizarCategoria(Long id, Categoria categoriaActualizada) {
        Categoria existente = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada para actualizar"));

        existente.setNombreCategoria(categoriaActualizada.getNombreCategoria());
        existente.setDescripcion(categoriaActualizada.getDescripcion());
        existente.setCategoriaPadre(categoriaActualizada.getCategoriaPadre());
        // Puedes agregar más campos si hay otros en tu modelo

        return categoriaRepository.save(existente);
    }

    // Eliminar una categoría por ID
    public void eliminarCategoria(Long id) {
        Categoria existente = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada para eliminar"));
        categoriaRepository.delete(existente);
    }
}
