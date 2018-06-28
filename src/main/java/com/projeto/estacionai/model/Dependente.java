package com.projeto.estacionai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 
 * 
 * @author ALISSON
 *
 */

@Entity
public class Dependente {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String email;
	
	@OneToOne
	@NotNull
	private Cliente clienteAssociado;
	
	public Dependente() {}

	public Dependente(@NotBlank String nome, @NotBlank String telefone, @NotBlank String cpf, @NotBlank String email,
			@NotNull Cliente clienteAssociado) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.email = email;
		this.clienteAssociado = clienteAssociado;
	}





	public String getNome() {
		return nome;
	}

	public Cliente getClienteAssociado() {
		return clienteAssociado;
	}





	public void setClienteAssociado(Cliente clienteAssociado) {
		this.clienteAssociado = clienteAssociado;
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
}