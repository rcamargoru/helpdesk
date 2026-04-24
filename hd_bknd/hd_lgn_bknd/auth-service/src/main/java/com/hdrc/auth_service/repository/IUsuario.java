/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hdrc.auth_service.repository;

import com.hdrc.auth_service.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */
@Repository
public interface IUsuario extends JpaRepository<Usuario, Long> {
//Optional<Usuario> findByNombreLgnUsuario(String nombreLgnUsuario);   


@EntityGraph(attributePaths = {
    "usuarioRoles",
    "usuarioRoles.rol",
    "usuarioRoles.rol.RolesPermiso"
})
    Optional<Usuario> findByNombreLgnUsuario(String login);


}
