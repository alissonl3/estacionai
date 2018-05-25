package com.projeto.estacionai.repository;

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
import org.springframework.util.StringUtils;

import com.projeto.estacionai.model.Cliente;
import com.projeto.estacionai.model.Dependente;

@Repository
public class DependenteRepositorySearch {

	@PersistenceContext
	private EntityManager manager;
	
	
	public List<Dependente> filtrar(Dependente dependente) {
		CriteriaBuilder builder =  manager.getCriteriaBuilder();
		CriteriaQuery<Dependente> criteria = builder.createQuery(Dependente.class);
		
		Root<Dependente> root = criteria.from(Dependente.class);
		
		Predicate[] predicates = restricoes(dependente, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Dependente> query = manager.createQuery(criteria);
		
		return query.getResultList(); 
	}
	
	private Predicate[] restricoes(Dependente dependente, CriteriaBuilder builder, Root<Dependente> root) {
		List<Predicate> predicates	= new ArrayList<>();
		
		
		if(!StringUtils.isEmpty(dependente.getCpf()))
			predicates.add(builder.equal(builder.lower(root.get("cpf")), 
				dependente.getCpf().toLowerCase() ));
		if(!StringUtils.isEmpty(dependente.getEmail()))
			predicates.add(builder.like(builder.lower(root.get("email")), 
					"%"+ dependente.getEmail().toLowerCase()+ "%"));
		if(!StringUtils.isEmpty(dependente.getNome()))
			predicates.add(builder.like(builder.lower(root.get("nome")), 
					"%" + dependente.getNome().toLowerCase() + "%"));
		if(!StringUtils.isEmpty(dependente.getTelefone()))
			predicates.add(builder.like(builder.lower(root.get("telefone")), 
					"%" + dependente.getTelefone().toLowerCase() + "%"));
		if(dependente.getClienteAssociado() != null && dependente.getClienteAssociado().getId() > 0)
			predicates.add(builder.equal(root.get("clienteAssociado"), 
					 dependente.getClienteAssociado().getId() ));
		
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
}
