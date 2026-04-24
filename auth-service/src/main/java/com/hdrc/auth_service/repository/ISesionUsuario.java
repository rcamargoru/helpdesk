/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hdrc.auth_service.repository;

import com.hdrc.auth_service.model.SesionUsuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */
@Repository
public interface ISesionUsuario extends JpaRepository<SesionUsuario, Long>{

    Optional<SesionUsuario> findByRefreshTokenAndActivoTrue(String refreshToken);

    Optional<SesionUsuario> findBySesionPrimIdAndActivoTrue(String sesionPrimId);

   // List<SesionUsuario> findBySesionPrimIdAndActivoTrue(Long usuarioId);   
}
