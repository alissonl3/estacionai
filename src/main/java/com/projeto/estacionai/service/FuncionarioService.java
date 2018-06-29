package com.projeto.estacionai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.estacionai.model.Funcionario;
import com.projeto.estacionai.repository.FuncionarioRepository;

/**
 * 
 * @author Eduardo
 *
 */

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	public void salvar (Funcionario funcionario) {
		this.repository.save(funcionario);
	}
	
	public void deletar(Long id)
	{
		this.repository.deleteById(id);
	}
	
	public List<Funcionario> buscarTodos()
	{
		return this.repository.findAll();
	}
	
	public Funcionario buscar(Long id)
	{
		return this.repository.getOne(id);
	}
}