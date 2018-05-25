package com.projeto.estacionai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.estacionai.model.Dependente;
import com.projeto.estacionai.repository.DependenteRepository;

/**
 * 
 * @author ALISSON
 *
 */

@Service
public class DependenteService {

	@Autowired
	private DependenteRepository repository;
	
	public void salvar (Dependente dependente) {
		this.repository.save(dependente);
	}
	
	public void deletar(Long id)
	{
		this.repository.deleteById(id);
	}
	
	public List<Dependente> buscarTodos()
	{
		return this.repository.findAll();
	}
	
	public Dependente buscar(Long id)
	{
		return this.repository.getOne(id);
	}
}