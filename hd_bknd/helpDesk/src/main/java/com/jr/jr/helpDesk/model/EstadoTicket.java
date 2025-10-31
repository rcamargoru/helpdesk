/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.helpDesk.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "HdEstadoTicket")
public class EstadoTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstadoTicket;

    private String nombreEstadoTicket;
    private String descripcion;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private LocalDateTime fechaActualizacion = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "creadoPor", nullable = false)
    private Usuario creadoPor;

    @ManyToOne
    @JoinColumn(name = "actualizadoPor", nullable = false)
    private Usuario actualizadoPor;

    @OneToMany(mappedBy = "estado")
    private List<Ticket> tickets;

    /**
     * @return the idEstadoTicket
     */
    public Long getIdEstadoTicket() {
        return idEstadoTicket;
    }

    /**
     * @param idEstadoTicket the idEstadoTicket to set
     */
    public void setIdEstadoTicket(Long idEstadoTicket) {
        this.idEstadoTicket = idEstadoTicket;
    }

    /**
     * @return the nombreEstadoTicket
     */
    public String getNombreEstadoTicket() {
        return nombreEstadoTicket;
    }

    /**
     * @param nombreEstadoTicket the nombreEstadoTicket to set
     */
    public void setNombreEstadoTicket(String nombreEstadoTicket) {
        this.nombreEstadoTicket = nombreEstadoTicket;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fechaCreacion
     */
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the fechaActualizacion
     */
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * @param fechaActualizacion the fechaActualizacion to set
     */
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    /**
     * @return the creadoPor
     */
    public Usuario getCreadoPor() {
        return creadoPor;
    }

    /**
     * @param creadoPor the creadoPor to set
     */
    public void setCreadoPor(Usuario creadoPor) {
        this.creadoPor = creadoPor;
    }

    /**
     * @return the actualizadoPor
     */
    public Usuario getActualizadoPor() {
        return actualizadoPor;
    }

    /**
     * @param actualizadoPor the actualizadoPor to set
     */
    public void setActualizadoPor(Usuario actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }

    /**
     * @return the tickets
     */
    public List<Ticket> getTickets() {
        return tickets;
    }

    /**
     * @param tickets the tickets to set
     */
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
