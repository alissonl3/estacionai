package com.projeto.estacionai.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projeto.estacionai.model.Cliente;

/**
 * 
 * @author Gui
 *
 */

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}