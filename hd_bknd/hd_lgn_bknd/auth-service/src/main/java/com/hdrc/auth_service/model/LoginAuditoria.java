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
@Table(name = "AuthGnLoginAuditoria")
public class LoginAuditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuditoriaAuth;

    private String usuarioAuth;
    private String oidAzure;
    private String ip;
    private LocalDateTime fechaLoginAuth;
    private String resultadoOperacion;
    private String tipoLoginAuth;
    private String origenAuth;

    @JsonBackReference // Rompe la referencia cíclica desde Rol
    @ManyToOne
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario usuario;

    public Long getIdAuditoriaAuth() {
        return idAuditoriaAuth;
    }

    public void setIdAuditoriaAuth(Long idAuditoriaAuth) {
        this.idAuditoriaAuth = idAuditoriaAuth;
    }

    public String getUsuarioAuth() {
        return usuarioAuth;
    }

    public void setUsuarioAuth(String usuarioAuth) {
        this.usuarioAuth = usuarioAuth;
    }

    public String getOidAzure() {
        return oidAzure;
    }

    public void setOidAzure(String oidAzure) {
        this.oidAzure = oidAzure;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDateTime getFechaLoginAuth() {
        return fechaLoginAuth;
    }

    public void setFechaLoginAuth(LocalDateTime fechaLoginAuth) {
        this.fechaLoginAuth = fechaLoginAuth;
    }

    public String getResultadoOperacion() {
        return resultadoOperacion;
    }

    public void setResultadoOperacion(String resultadoOperacion) {
        this.resultadoOperacion = resultadoOperacion;
    }

    /**
     * @return the tipoLoginAuth
     */
    public String getTipoLoginAuth() {
        return tipoLoginAuth;
    }

    public void setTipoLoginAuth(String tipoLoginAuth) {
        this.tipoLoginAuth = tipoLoginAuth;
    }

    public String getOrigenAuth() {
        return origenAuth;
    }

    public void setOrigenAuth(String origenAuth) {
        this.origenAuth = origenAuth;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
