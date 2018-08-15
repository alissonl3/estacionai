/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.estacionai.repository;

import com.projeto.estacionai.model.HistoricoEntradaSaida;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author ALISSON
 */
@Component
public class HistoricoEntradaSaidaRepositoryObserver {
    
    
	private final String INSERT_SQL = "INSERT INTO historico_entrada_saida(codigo, horario_chegada, ativo, horario_saida) values(:codigo,:horario_chegada,:ativo, :horario_saida)";

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public HistoricoEntradaSaidaRepositoryObserver()
	{ }

	public void save(HistoricoEntradaSaida hes) {
		KeyHolder holder = new GeneratedKeyHolder();
			SqlParameterSource parameters = new MapSqlParameterSource()
					.addValue("codigo", hes.getCodigo())
					.addValue("horario_chegada", hes.getHorarioChegada())
					.addValue("ativo", hes.getAtivo())
					.addValue("horario_saida", hes.getHorarioSaida());
			namedParameterJdbcTemplate.update(INSERT_SQL, parameters, holder);
		}

}
