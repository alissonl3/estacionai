/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.estacionai.repository;

import com.projeto.estacionai.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alisson
 */
@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    
	@Query(value = "SELECT SUM(id) FROM sensor WHERE ligado = true", nativeQuery = true)
    public Integer countSensoresLigados();
	
}
