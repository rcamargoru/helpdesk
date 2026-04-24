/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.helpDesk.controller;

import com.jr.jr.helpDesk.model.Ticket;
import com.jr.jr.helpDesk.service.TicketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ricardo
 */
@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/api/v3/helpdesk/tickets")
public class ControllerTicket {

    @Autowired
    private TicketService ticketService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Ticket crearTicket(@RequestBody Ticket ticket) {
        return ticketService.crearTicket(ticket);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Ticket> obtenerTodosLosTickets() {
        System.out.println("sasd");
        return ticketService.listarTickets();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public Ticket obtenerTicketPorId(@PathVariable Long id) {
        return ticketService.obtenerTicket(id);
    }

}
