package com.projeto.estacionai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.estacionai.model.Veiculo;
import com.projeto.estacionai.repository.VeiculoRepository;

/**
 * 
 * @author ALISSON 
 *
 */

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repository;
	
	public void salvar(Veiculo veiculo)
	{
		this.repository.save(veiculo);
	}
	
	
	public void deletar(Long id)
	{
		this.repository.deleteById(id);
	}
	
	public List<Veiculo> buscarTodos()
	{
		return this.repository.findAll();
	}
	
	public Veiculo buscar(Long id)
	{
		return this.repository.getOne(id);
	}
	
	public List<Veiculo> buscarEspecifico(Veiculo veiculo)
	{
		
		return null;
		
	}

}
