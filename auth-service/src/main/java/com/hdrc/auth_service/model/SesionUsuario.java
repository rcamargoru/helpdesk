/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hdrc.auth_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Administrador
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AuthGnSesionUsuario")
public class SesionUsuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSesionUsuario;

    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "idUsuarioAuth")
    private Usuario usuario;

    @Column(nullable = false, length = 500)
    private String refreshToken;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaExpiracion;

    @Column(nullable = false)
    private Boolean activo = true;

    @Column(name = "ip_cliente", length = 100)
    private String ipCliente;

    @Column(length = 255)
    private String dispositivo;

    @Column(nullable = false, length = 150)
    private String sesionPrimId;

    // =========================
    // Getters y Setters
    // =========================

    public Long getIdSesionUsuario() {
        return idSesionUsuario;
    }

    public void setIdSesionUsuario(Long idSesionUsuario) {
        this.idSesionUsuario = idSesionUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getIpCliente() {
        return ipCliente;
    }

    public void setIpCliente(String ipCliente) {
        this.ipCliente = ipCliente;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getSesionPrimId() {
        return sesionPrimId;
    }

    public void setSesionPrimId(String sesionPrimId) {
        this.sesionPrimId = sesionPrimId;
    }
    
}   
