/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hdrc.auth_service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 *
 * @author Rc
 */
@Entity
@Table(name = "AuthGnRolPermiso")
public class RolPermiso {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)      
private Long idRolPermisoAuth;

    @JsonBackReference(value = "permiso-rol") // Rompe la referencia cíclica desde permiso
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permisoAuth", nullable = false)
    private Permiso permiso;

    @JsonBackReference(value = "rol-permiso") // Rompe la referencia cíclica desde Rol
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rolAuth", nullable = false)
    private Rol rol;        


private LocalDateTime fechaCreacionRolPermiso = LocalDateTime.now();
private String creadoPor;
private LocalDateTime fechaInicio;
private LocalDateTime fechaFin;
private boolean activo;   

    /**
     * @return the idRolPermisoAuth
     */
    public Long getIdRolPermisoAuth() {
        return idRolPermisoAuth;
    }

    /**
     * @param idRolPermisoAuth the idRolPermisoAuth to set
     */
    public void setIdRolPermisoAuth(Long idRolPermisoAuth) {
        this.idRolPermisoAuth = idRolPermisoAuth;
    }

    /**
     * @return the permiso
     */
    public Permiso getPermiso() {
        return permiso;
    }

    /**
     * @param permiso the permiso to set
     */
    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    /**
     * @return the rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    /**
     * @return the fechaCreacionRolPermiso
     */
    public LocalDateTime getFechaCreacionRolPermiso() {
        return fechaCreacionRolPermiso;
    }

    /**
     * @param fechaCreacionRolPermiso the fechaCreacionRolPermiso to set
     */
    public void setFechaCreacionRolPermiso(LocalDateTime fechaCreacionRolPermiso) {
        this.fechaCreacionRolPermiso = fechaCreacionRolPermiso;
    }

    /**
     * @return the creadoPor
     */
    public String getCreadoPor() {
        return creadoPor;
    }

    /**
     * @param creadoPor the creadoPor to set
     */
    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    /**
     * @return the fechaInicio
     */
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
