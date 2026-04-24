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
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "HdTicket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;

    private String titulo;

    @Lob
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "usuarioCreador", nullable = false)
    private Usuario usuarioCreador;

    @ManyToOne
    @JoinColumn(name = "agente", nullable = false)
    private Usuario agente;

    @ManyToOne
    @JoinColumn(name = "prioridad", nullable = false)
    private Prioridad prioridad;

    @ManyToOne
    @JoinColumn(name = "categoria", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "area", nullable = false)
    private Area area;

    @ManyToOne
    @JoinColumn(name = "estado", nullable = false)
    private EstadoTicket estado;

    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private LocalDateTime fechaActualizacion = LocalDateTime.now();
    private LocalDateTime fechaCierre = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "creadoPor", nullable = false)
    private Usuario creadoPor;

    @ManyToOne
    @JoinColumn(name = "actualizadoPor", nullable = false)
    private Usuario actualizadoPor;

    private LocalDateTime fechaUltimaMod = LocalDateTime.now();

    /**
     * @return the idTicket
     */
    public Long getIdTicket() {
        return idTicket;
    }

    /**
     * @param idTicket the idTicket to set
     */
    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
     * @return the usuarioCreador
     */
    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    /**
     * @param usuarioCreador the usuarioCreador to set
     */
    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    /**
     * @return the agente
     */
    public Usuario getAgente() {
        return agente;
    }

    /**
     * @param agente the agente to set
     */
    public void setAgente(Usuario agente) {
        this.agente = agente;
    }

    /**
     * @return the prioridad
     */
    public Prioridad getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the area
     */
    public Area getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Area area) {
        this.area = area;
    }

    /**
     * @return the estado
     */
    public EstadoTicket getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EstadoTicket estado) {
        this.estado = estado;
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
     * @return the fechaCierre
     */
    public LocalDateTime getFechaCierre() {
        return fechaCierre;
    }

    /**
     * @param fechaCierre the fechaCierre to set
     */
    public void setFechaCierre(LocalDateTime fechaCierre) {
        this.fechaCierre = fechaCierre;
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
     * @return the fechaUltimaMod
     */
    public LocalDateTime getFechaUltimaMod() {
        return fechaUltimaMod;
    }

    /**
     * @param fechaUltimaMod the fechaUltimaMod to set
     */
    public void setFechaUltimaMod(LocalDateTime fechaUltimaMod) {
        this.fechaUltimaMod = fechaUltimaMod;
    }

}
   