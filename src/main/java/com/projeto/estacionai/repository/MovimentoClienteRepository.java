package com.projeto.estacionai.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projeto.estacionai.model.MovimentoCliente;

/**
 * 
 * @author Alisson
 *
 */

@Repository
public interface MovimentoClienteRepository extends JpaRepository<MovimentoCliente, Long> {

}