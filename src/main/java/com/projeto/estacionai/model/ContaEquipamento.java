/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.estacionai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Alisson
 */
@Entity
public class ContaEquipamento {
	
	public ContaEquipamento()
	{
		
	}

	public ContaEquipamento(@NotBlank String nome, @NotBlank String estado, @NotBlank String lugarReparo) {
		super();
		this.nome = nome;
		this.estado = estado;
		this.lugarReparo = lugarReparo;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String estado;
	
	@NotBlank
	private String lugarReparo;
	
	private Boolean ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLugarReparo() {
		return lugarReparo;
	}

	public void setLugarReparo(String lugarReparo) {
		this.lugarReparo = lugarReparo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
	
	
	
    
    
	
	
}