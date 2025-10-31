/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.helpDesk.controller;

import com.jr.jr.helpDesk.model.Categoria;
import com.jr.jr.helpDesk.model.Usuario;
import com.jr.jr.helpDesk.service.CategoriaService;
import com.jr.jr.helpDesk.util.JwtUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ricardo
 */
@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/api/v3/helpdesk/admin/categorias")
public class ControllerCategoria {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private JwtUtil jwtUtilService;

    // Obtener todas las prioridades
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Categoria>> obtenerTodasLasCategorias() {
        System.out.println("llega aca la categoria?");
        List<Categoria> categorias = categoriaService.obtenerCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    // Crear una nueva categoria
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria, @RequestHeader("Authorization") String tokenJwt) {
        String token = tokenJwt.substring(7);
        String username = jwtUtilService.extractUsername(token); // El nombre del usuario del token JWT
        Usuario usuario = categoriaService.obtenerUsuarioPorNombre(username, token);
        categoria.setIdCategoria(null);
        categoria.setCreadoPor(usuario);
        categoria.setActualizadoPor(usuario);
        return categoriaService.crearCategoria(categoria);
    }
//
    // Obtener una categoria por su ID
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCategoriaPorId(@PathVariable Long id) {
        Categoria categoria = categoriaService.obtenerCategoria(id);
        if (categoria != null) {
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//
//    // Actualizar una categoria existente
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        System.out.println("asdasdasdasd");
        Categoria categoriaActualizada = categoriaService.actualizarCategoria(id, categoria);
        if (categoriaActualizada != null) {
            return new ResponseEntity<>(categoriaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
