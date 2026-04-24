/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jr.jr.helpDesk.repository;

import com.jr.jr.helpDesk.model.Ticket;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ricardo
 */
@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long>{

    //public List<Ticket> findByAgente(Long usuarioId);

}
