/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.estacionai.repository;

import com.projeto.estacionai.model.ContaPagar;
import com.projeto.estacionai.model.MovimentoCliente;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alisson
 */
@Repository
public class RelatorioMovimentoClienteRepositorySearch {

	@PersistenceContext
	private EntityManager manager;
	
	
	public List<MovimentoCliente> filtrar(MovimentoCliente movimento) {
		CriteriaBuilder builder =  manager.getCriteriaBuilder();
		CriteriaQuery<MovimentoCliente> criteria = builder.createQuery(MovimentoCliente.class);
		
		Root<ContaPagar> root = criteria.from(ContaPagar.class);
		
		Predicate[] predicates = restricoes(movimento, builder, root);
		criteria.where(predicates);
		
		TypedQuery<MovimentoCliente> query = manager.createQuery(criteria);
		
		return query.getResultList(); 
	}
	
	private Predicate[] restricoes(MovimentoCliente movimento, CriteriaBuilder builder, Root<ContaPagar> root) {
		List<Predicate> predicates	= new ArrayList<>();
			
		if(movimento.getDataInicio() != null && movimento.getDataFim() != null)	
		{
			predicates.add(builder.lessThanOrEqualTo(root.get("dataMovimento"), movimento.getDataFim()));
			predicates.add(builder.greaterThanOrEqualTo(root.get("dataMovimento"), movimento.getDataInicio()));
		}
		if(movimento.getAtivo() != null)	
			predicates.add(builder.equal(root.get("ativo"), 
					movimento.getAtivo()));
		
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
}

