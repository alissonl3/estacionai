package com.projeto.estacionai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * 
 * @author Gui
 *
 */

@Entity
public class Cliente {
	
	// Atributos
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String telefone;
	
	private String endereco;
	
	private String cpf;
	
	private int tipoPagamento;
	
	private int numeroVagas;
	
	// Funções
	
	Cliente(String nome, String telefone, String endereco, String cpf, int tipoP, int numeroV){
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
		this.tipoPagamento = tipoP;
		this.numeroVagas = numeroV;
	}
	
	// Gets e Sets Cliente

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(int tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public int getNumeroVagas() {
		return numeroVagas;
	}

	public void setNumeroVagas(int numeroVagas) {
		this.numeroVagas = numeroVagas;
	}
	
	
}