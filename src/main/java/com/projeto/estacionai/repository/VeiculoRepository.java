package com.projeto.estacionai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.estacionai.model.Veiculo;
 
/**
 * 
 * @author ALISSON
 *
 */

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	public List<Veiculo> findByPlacaLikeOrMensalista(String placa, boolean mensalista);
	
	public List<Veiculo> findByPlacaLikeAndMensalista(String placa, boolean mensalista);
	
	public List<Veiculo> findByPlacaLike(String placa);

}
