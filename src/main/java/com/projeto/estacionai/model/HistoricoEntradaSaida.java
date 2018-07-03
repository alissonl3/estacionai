/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.estacionai.model;

import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.projeto.estacionai.util.LocalDateTimeAttributeConverter;

/**
 *
 * @author ALISSON
 */
@Entity
public class HistoricoEntradaSaida {

	public HistoricoEntradaSaida(@NotBlank String codigo, @NotNull LocalDateTime horarioChegada,
			LocalDateTime horarioSaida) {
		super();
		this.codigo = codigo;
		this.horarioChegada = horarioChegada;
		this.horarioSaida = horarioSaida;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String codigo;

	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime horarioChegada;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime horarioSaida;
	

	
	public HistoricoEntradaSaida(){}    


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getHorarioChegada() {
		return horarioChegada;
	}


	public void setHorarioChegada(LocalDateTime horarioChegada) {
		this.horarioChegada = horarioChegada;
	}


	public LocalDateTime getHorarioSaida() {
		return horarioSaida;
	}


	public void setHorarioSaida(LocalDateTime horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	

		@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoricoEntradaSaida other = (HistoricoEntradaSaida) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
