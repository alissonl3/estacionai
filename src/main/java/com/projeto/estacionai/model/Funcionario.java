package com.projeto.estacionai.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 
 * 
 * @author Eduardo
 *
 */

@Entity
public class Funcionario {
	
	public Funcionario(@NotBlank String nome, @NotBlank String telefone, @NotBlank String funcao, @NotBlank String cpf,
			@NotBlank String pis, @NotNull Integer nivelPermissao) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.funcao = funcao;
		this.cpf = cpf;
		this.pis = pis;
		this.nivelPermissao = nivelPermissao;
	}


	public Funcionario(@NotBlank String nome, @NotBlank String telefone, @NotBlank String funcao, @NotBlank String cpf,
			@NotBlank String pis, @NotNull Integer nivelPermissao, String senha) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.funcao = funcao;
		this.cpf = cpf;
		this.pis = pis;
		this.nivelPermissao = nivelPermissao;
		this.senha = senha;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String funcao;
	
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String pis;
	
	@NotNull
	private Integer nivelPermissao;
	
	
	private String senha;
	
	private Boolean ativo;
	
	// Funções

	public Funcionario() {}

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public Integer getNivelPermissao() {
		return nivelPermissao;
	}

	public void setNivelPermissao(Integer nivelPermissao) {
		this.nivelPermissao = nivelPermissao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Boolean getAtivo() {
		return ativo;
	}


	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	
	
	
	
}