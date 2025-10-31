/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.helpDesk.service;

import com.jr.jr.helpDesk.model.EstadoTicket;
import com.jr.jr.helpDesk.model.Ticket;
import com.jr.jr.helpDesk.repository.CategoriaRepo;
import com.jr.jr.helpDesk.repository.EstadoTicketRepo;
import com.jr.jr.helpDesk.repository.PrioridadRepo;
import com.jr.jr.helpDesk.repository.TicketRepo;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ricardo
 */
@Service
public class TicketService {
    
 @Autowired
    private TicketRepo ticketRepository;

    // Método para crear un nuevo ticket
    public Ticket crearTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Método para listar todos los tickets
    public List<Ticket> listarTickets() {
        return ticketRepository.findAll();
    }

    // Método para obtener un ticket por ID
    public Ticket obtenerTicket(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket.orElseThrow(() -> new RuntimeException("Ticket no encontrado con ID: " + id));
    }

    // Método para actualizar un ticket existente
    public Ticket actualizarTicket(Long id, Ticket ticketActualizado) {
        Ticket ticketExistente = obtenerTicket(id);
        ticketExistente.setTitulo(ticketActualizado.getTitulo());
        ticketExistente.setDescripcion(ticketActualizado.getDescripcion());
        ticketExistente.setEstado(ticketActualizado.getEstado());
        ticketExistente.setPrioridad(ticketActualizado.getPrioridad());
        ticketExistente.setCategoria(ticketActualizado.getCategoria());
        // Otros campos que necesites actualizar
        return ticketRepository.save(ticketExistente);
    }

    // Método para eliminar un ticket por ID
    public void eliminarTicket(Long id) {
        if (!ticketRepository.existsById(id)) {
            throw new RuntimeException("Ticket no encontrado con ID: " + id);
        }
        ticketRepository.deleteById(id);
    }
}