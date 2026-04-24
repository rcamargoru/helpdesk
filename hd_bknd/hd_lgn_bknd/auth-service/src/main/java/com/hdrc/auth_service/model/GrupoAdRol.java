/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hdrc.auth_service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
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
@Table(name = "AuthGnGrupoAdRol")
public class GrupoAdRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrupoRolAuth;

    private String azureGroupIdAuth;
    private String nombreGrupoAuth;

    @JsonBackReference // Rompe la referencia cíclica desde Rol
    @ManyToOne
    @JoinColumn(name = "rol", nullable = false)
     private Rol rol;

    private LocalDateTime fechaCreacionAuthGrupo = LocalDateTime.now();
    private String creadoPor;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private boolean activo;


    public Long getIdGrupoRolAuth() {
        return idGrupoRolAuth;
    }

    public void setIdGrupoRolAuth(Long idGrupoRolAuth) {
        this.idGrupoRolAuth = idGrupoRolAuth;
    }

    public String getAzureGroupIdAuth() {
        return azureGroupIdAuth;
    }

    public void setAzureGroupIdAuth(String azureGroupIdAuth) {
        this.azureGroupIdAuth = azureGroupIdAuth;
    }

    public String getNombreGrupoAuth() {
        return nombreGrupoAuth;
    }
    
    public void setNombreGrupoAuth(String nombreGrupoAuth) {
        this.nombreGrupoAuth = nombreGrupoAuth;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public LocalDateTime getFechaCreacionAuthGrupo() {
        return fechaCreacionAuthGrupo;
    }

    public void setFechaCreacionAuthGrupo(LocalDateTime fechaCreacionAuthGrupo) {
        this.fechaCreacionAuthGrupo = fechaCreacionAuthGrupo;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
