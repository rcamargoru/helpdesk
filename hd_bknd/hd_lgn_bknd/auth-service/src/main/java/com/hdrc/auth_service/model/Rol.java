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
import java.util.Set;

/**
 *
 * @author Rc
 */
@Entity
@Table(name = "AuthGnRol")
public class Rol {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRolAuth;

@JsonManagedReference(value = "rol-usuario")
@OneToMany(mappedBy = "rol")
private Set<UsuarioRol> usuarioRoles;
    
    @JsonManagedReference(value = "rol-permiso") // Rompe la referencia cíclica hacia RolesPermisos
    @OneToMany(mappedBy = "rol")
    private Set<RolPermiso> RolesPermiso;
     

    private String nombreRolAuth;
    private String descripcionRolAuth;
    private boolean estadoRol;
    private LocalDateTime fechaCreacionRol = LocalDateTime.now();
    private String creadoPor;
    private LocalDateTime fechaActualizacionRol;
    private String actualizadoPor;

    public Long getIdRolAuth() {
        return idRolAuth;
    }

    public void setIdRolAuth(Long idRolAuth) {
        this.idRolAuth = idRolAuth;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }
    public String getNombreRolAuth() {
        return nombreRolAuth;
    }
    public Set<RolPermiso> getRolesPermiso() {
        return RolesPermiso;
    }

    public void setRolesPermiso(Set<RolPermiso> RolesPermiso) {
        this.RolesPermiso = RolesPermiso;
    }
    public void setNombreRolAuth(String nombreRolAuth) {
        this.nombreRolAuth = nombreRolAuth;
    }

    public String getDescripcionRolAuth() {
        return descripcionRolAuth;
    }

    public void setDescripcionRolAuth(String descripcionRolAuth) {
        this.descripcionRolAuth = descripcionRolAuth;
    }

    public boolean isEstadoRol() {
        return estadoRol;
    }

    public void setEstadoRol(boolean estadoRol) {
        this.estadoRol = estadoRol;
    }

    public LocalDateTime getFechaCreacionRol() {
        return fechaCreacionRol;
    }

    public void setFechaCreacionRol(LocalDateTime fechaCreacionRol) {
        this.fechaCreacionRol = fechaCreacionRol;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public LocalDateTime getFechaActualizacionRol() {
        return fechaActualizacionRol;
    }

    public void setFechaActualizacionRol(LocalDateTime fechaActualizacionRol) {
        this.fechaActualizacionRol = fechaActualizacionRol;
    }

    public String getActualizadoPor() {
        return actualizadoPor;
    }

    public void setActualizadoPor(String actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }

}
