package com.projeto.estacionai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.estacionai.model.MovimentoCliente;
import com.projeto.estacionai.repository.MovimentoClienteRepository;

/**
 * 
 * @author Alisson
 *
 */

@Service
public class MovimentoClienteService {

	@Autowired
	private MovimentoClienteRepository repository;
	
	public void salvar (MovimentoCliente movimento) {
		movimento.setAtivo(true);
		this.repository.save(movimento);
	}
	
	public void deletar (MovimentoCliente movimento) {
		movimento.setAtivo(false);
		this.repository.save(movimento);
	}
	
	public void deletar(Long id)
	{
		this.repository.deleteById(id);
	}
	
	public List<MovimentoCliente> buscarTodos()
	{
		return this.repository.findByAtivoTrue();
	}
	
	public MovimentoCliente buscar(Long id)
	{
		return this.repository.getOne(id);
	}
}