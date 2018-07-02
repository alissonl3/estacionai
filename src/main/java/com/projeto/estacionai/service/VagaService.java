/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.estacionai.service;

import com.projeto.estacionai.model.Vaga;
import com.projeto.estacionai.repository.VagaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo
 */
@Service
public class VagaService {
    @Autowired
    private VagaRepository repository;
	
    public void salvar(Vaga vaga)
    {
        this.repository.save(vaga);
    }
	
    public void deletar(Long id)
    {
        this.repository.deleteById(id);
    }
	
    public List<Vaga> buscarTodos()
    {
        return this.repository.findAll();
    }
    
    public List<Vaga> buscarTodosDesocupadas()
    {
        return this.repository.findByOcupadaFalse();
    }
	
    public Vaga buscar(Long id)
    {
        return this.repository.getOne(id);
    }
    
    public List<Vaga> buscarVagasBloco()
    {
    	return null;
    }
}

