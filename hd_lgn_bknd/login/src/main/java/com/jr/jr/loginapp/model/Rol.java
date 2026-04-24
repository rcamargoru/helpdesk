/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.loginapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "GnRol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    
    private String nombreRol;
    private String descripcionRol;
    private boolean estado;
    private Long creadoPor;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private Long actualizadoPor;
    private LocalDateTime fechaActualizacion;

    @JsonManagedReference // Rompe la referencia cíclica hacia UsuarioGrupo
    @OneToMany(mappedBy = "rol")
    private List<UsuarioRol> usuarioRoles;

    /**
     * @return the idRol
     */
    public Long getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the nombreRol
     */
    public String getNombreRol() {
        return nombreRol;
    }

    /**
     * @param nombreRol the nombreRol to set
     */
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the descripcionRol
     */
    public String getDescripcionRol() {
        return descripcionRol;
    }

    /**
     * @param descripcionRol the descripcionRol to set
     */
    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
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
     * @return the usuarioRoles
     */
    public List<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    /**
     * @param usuarioRoles the usuarioRoles to set
     */
    public void setUsuarioRoles(List<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

    /**
     * @return the creadoPor
     */
    public Long getCreadoPor() {
        return creadoPor;
    }

    /**
     * @param creadoPor the creadoPor to set
     */
    public void setCreadoPor(Long creadoPor) {
        this.creadoPor = creadoPor;
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
     * @return the actualizadoPor
     */
    public Long getActualizadoPor() {
        return actualizadoPor;
    }

    /**
     * @param actualizadoPor the actualizadoPor to set
     */
    public void setActualizadoPor(Long actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }

}
