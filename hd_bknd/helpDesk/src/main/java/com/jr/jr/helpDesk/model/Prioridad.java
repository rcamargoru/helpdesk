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
@Table(name = "HdPrioridad")
public class Prioridad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrioridad;

    private String nombrePrioridad;
    private String descripcion;
    private int nivel;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private LocalDateTime fechaActualizacion = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "creadoPor", referencedColumnName = "idUsuario")
    private Usuario creadoPor;

    @ManyToOne
    @JoinColumn(name = "actualizadoPor", referencedColumnName = "idUsuario")
    private Usuario actualizadoPor;

    @OneToMany(mappedBy = "prioridad")
    private List<Ticket> tickets;

    /**
     * @return the idPrioridad
     */
    public Long getIdPrioridad() {
        return idPrioridad;
    }

    /**
     * @param idPrioridad the idPrioridad to set
     */
    public void setIdPrioridad(Long idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    /**
     * @return the nombrePrioridad
     */
    public String getNombrePrioridad() {
        return nombrePrioridad;
    }

    /**
     * @param nombrePrioridad the nombrePrioridad to set
     */
    public void setNombrePrioridad(String nombrePrioridad) {
        this.nombrePrioridad = nombrePrioridad;
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
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
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

//    /**
//     * @return the creadoPor
//     */
    public Usuario getCreadoPor() {
        return creadoPor;
    }
//
//    /**
//     * @param creadoPor the creadoPor to set
//     */
    public void setCreadoPor(Usuario creadoPor) {
        this.creadoPor = creadoPor;
    }
//
//    /**
//     * @return the actualizadoPor
//     */
    public Usuario getActualizadoPor() {
        return actualizadoPor;
    }
//
//    /**
//     * @param actualizadoPor the actualizadoPor to set
//     */
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
