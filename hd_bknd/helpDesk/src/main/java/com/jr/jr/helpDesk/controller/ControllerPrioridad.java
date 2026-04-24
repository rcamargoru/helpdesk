/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.helpDesk.controller;

import com.jr.jr.helpDesk.model.Prioridad;
import com.jr.jr.helpDesk.model.Usuario;
import com.jr.jr.helpDesk.service.PrioridadService;
import com.jr.jr.helpDesk.util.JwtUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ricardo
 */
@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/api/v3/helpdesk/admin/prioridades")
public class ControllerPrioridad {

    @Autowired
    private PrioridadService prioridadService;

    @Autowired
    private JwtUtil jwtUtilService;

    // Obtener todas las prioridades
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Prioridad>> obtenerTodasLasPrioridades() {
        System.out.println("llega aca?");
        List<Prioridad> prioridades = prioridadService.obtenerPrioridades();
        return new ResponseEntity<>(prioridades, HttpStatus.OK);
    }

    // Crear una nueva prioridad
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Prioridad crearPrioridad(@RequestBody Prioridad prioridad, @RequestHeader("Authorization") String tokenJwt) {
        String token = tokenJwt.substring(7);
        String username = jwtUtilService.extractUsername(token); // El nombre del usuario del token JWT
        Usuario usuario = prioridadService.obtenerUsuarioPorNombre(username, token);

        prioridad.setIdPrioridad(null);
        prioridad.setCreadoPor(usuario);
        prioridad.setActualizadoPor(usuario);
        return prioridadService.crearPrioridad(prioridad);
    }

    // Obtener una prioridad por su ID
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Prioridad> obtenerPrioridadPorId(@PathVariable Long id) {
        Prioridad prioridad = prioridadService.obtenerPrioridad(id);
        if (prioridad != null) {
            return new ResponseEntity<>(prioridad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar una prioridad existente
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Prioridad> actualizarPrioridad(@PathVariable Long id, @RequestBody Prioridad prioridad) {
        System.out.println("asdasdasdasd");
        Prioridad prioridadActualizada = prioridadService.actualizarPrioridad(id, prioridad);
        if (prioridadActualizada != null) {
            return new ResponseEntity<>(prioridadActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
