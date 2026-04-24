/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hdrc.auth_service.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Rc
 */
@Entity
@Table(name = "AuthGnPermiso")
public class Permiso {
 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)    
private Long idPermisoAuth;

private String codigoPermisoAuth;
private String nombrePermisoAuth;
private String moduloAuth;
private boolean estadoPermiso;
private LocalDateTime fechaCreacionPermiso  = LocalDateTime.now();
private String creadoPor;
private LocalDateTime fechaActualizacionPermiso;
private String actualizadoPor;

    @JsonManagedReference(value = "permiso-rol") // Rompe la referencia cíclica hacia RolPermiso
    @OneToMany(mappedBy = "permiso")
     private List<RolPermiso> RolesPermiso;   

    public Long getIdPermisoAuth() {
        return idPermisoAuth;
    }

    public void setIdPermisoAuth(Long idPermisoAuth) {
        this.idPermisoAuth = idPermisoAuth;
    }

    public String getCodigoPermisoAuth() {
        return codigoPermisoAuth;
    }

    public void setCodigoPermisoAuth(String codigoPermisoAuth) {
        this.codigoPermisoAuth = codigoPermisoAuth;
    }

    public String getNombrePermisoAuth() {
        return nombrePermisoAuth;
    }

    public void setNombrePermisoAuth(String nombrePermisoAuth) {
        this.nombrePermisoAuth = nombrePermisoAuth;
    }

    public String getModuloAuth() {
        return moduloAuth;
    }

    public void setModuloAuth(String moduloAuth) {
        this.moduloAuth = moduloAuth;
    }

    public boolean isEstadoPermiso() {
        return estadoPermiso;
    }

    public void setEstadoPermiso(boolean estadoPermiso) {
        this.estadoPermiso = estadoPermiso;
    }

    public LocalDateTime getFechaCreacionPermiso() {
        return fechaCreacionPermiso;
    }

    public void setFechaCreacionPermiso(LocalDateTime fechaCreacionPermiso) {
        this.fechaCreacionPermiso = fechaCreacionPermiso;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public LocalDateTime getFechaActualizacionPermiso() {
        return fechaActualizacionPermiso;
    }

    public void setFechaActualizacionPermiso(LocalDateTime fechaActualizacionPermiso) {
        this.fechaActualizacionPermiso = fechaActualizacionPermiso;
    }

    public String getActualizadoPor() {
        return actualizadoPor;
    }

    public void setActualizadoPor(String actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }

    public List<RolPermiso> getRolesPermiso() {
        return RolesPermiso;
    }

    public void setRolesPermiso(List<RolPermiso> RolesPermiso) {
        this.RolesPermiso = RolesPermiso;
    }
    
}
