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
@Table(name = "AuthGnUsuario")
public class Usuario {

    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idUsuarioAuth;

@JsonManagedReference(value = "usuario-rol")
@OneToMany(mappedBy = "usuario")
private List<UsuarioRol> usuarioRoles;

private String oIdAzure;
private String idTenant;
private String nombreLgnUsuario;
private String hashPwd;
private String nombreUsuario;
private String apellidoUsuario;
private String emailUsuario;
private String tipoAutenticacionUsuario;
private int estadoUsuario;
private LocalDateTime fechaCreacionUsuario  = LocalDateTime.now();
private String creadoPor;
private LocalDateTime fechaActualizacionUsuario;
private String actualizadoPor;

    public Long getIdUsuarioAuth() {
        return idUsuarioAuth;
    }
    
    public void setIdUsuarioAuth(Long idUsuarioAuth) {
        this.idUsuarioAuth = idUsuarioAuth;
    }

    public List<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(List<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }
    public String getoIdAzure() {
        return oIdAzure;
    }

    public void setoIdAzure(String oIdAzure) {
        this.oIdAzure = oIdAzure;
    }

    public String getIdTenant() {
        return idTenant;
    }

    public void setIdTenant(String idTenant) {
        this.idTenant = idTenant;
    }

    public String getNombreLgnUsuario() {
        return nombreLgnUsuario;
    }

    public void setNombreLgnUsuario(String nombreLgnUsuario) {
        this.nombreLgnUsuario = nombreLgnUsuario;
    }

    public String getHashPwd() {
        return hashPwd;
    }

    public void setHashPwd(String hashPwd) {
        this.hashPwd = hashPwd;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getTipoAutenticacionUsuario() {
        return tipoAutenticacionUsuario;
    }

    public void setTipoAutenticacionUsuario(String tipoAutenticacionUsuario) {
        this.tipoAutenticacionUsuario = tipoAutenticacionUsuario;
    }

    public int getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(int estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public LocalDateTime getFechaCreacionUsuario() {
        return fechaCreacionUsuario;
    }

    public void setFechaCreacionUsuario(LocalDateTime fechaCreacionUsuario) {
        this.fechaCreacionUsuario = fechaCreacionUsuario;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public LocalDateTime getFechaActualizacionUsuario() {
        return fechaActualizacionUsuario;
    }

    public void setFechaActualizacionUsuario(LocalDateTime fechaActualizacionUsuario) {
        this.fechaActualizacionUsuario = fechaActualizacionUsuario;
    }

    public String getActualizadoPor() {
        return actualizadoPor;
    }

    public void setActualizadoPor(String actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }
    
}
