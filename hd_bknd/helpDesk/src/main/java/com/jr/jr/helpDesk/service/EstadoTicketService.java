/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.helpDesk.service;

import com.jr.jr.helpDesk.model.EstadoTicket;
import com.jr.jr.helpDesk.repository.EstadoTicketRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ricardo
 */
@Service
public class EstadoTicketService {
    
 @Autowired
    private EstadoTicketRepo estadoRepository;

    // Crear un estado
    public EstadoTicket crearEstado(EstadoTicket estado) {
        return estadoRepository.save(estado);
    }

    // Obtener todos los estados
    public List<EstadoTicket> obtenerEstados() {
        return estadoRepository.findAll();
    }

    // Obtener estado por ID
    public EstadoTicket obtenerEstado(Long id) {
        return estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
    }

    // Obtener estado por nombre
    public Optional<EstadoTicket> obtenerEstadoPorNombre(String nombre) {
        return estadoRepository.findByNombreEstadoTicket(nombre);
    }    
}
