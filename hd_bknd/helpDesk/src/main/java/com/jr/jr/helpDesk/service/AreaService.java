/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.helpDesk.service;

import com.jr.jr.helpDesk.model.Area;
import com.jr.jr.helpDesk.repository.AreaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ricardo
 */
@Service
public class AreaService {
      
 @Autowired
    private AreaRepo areaRepo;

    // Crear una categoría
    public Area crearArea(Area area) {
        return areaRepo.save(area);
    }

    // Obtener todas las categorías
    public List<Area> obtenerAreas() {
        return areaRepo.findAll();
    }

    // Obtener categoría por ID
    public Area obtenerArea(Long id) {
        return areaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Area no encontrada"));
    }
    
}
