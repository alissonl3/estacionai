/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.estacionai.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Eduardo
 */
@Entity
public class Bloco {
	
	// Atributos
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private List<Vaga> vagas;
	
        private int maxVagas;
        
	
	public Bloco(int maxVagas){
		this.vagas = new ArrayList<Vaga>();
                this.maxVagas = maxVagas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
        
        public List<Vaga> getVagas() {
		return vagas;
	}
        
        private int getNumVagas(){
            return vagas.size();
        }

	public boolean addVaga(Vaga vaga){
            if(getNumVagas() < maxVagas){
                vagas.add(vaga);
                return true;
            }
            return false;
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
		Bloco other = (Bloco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}