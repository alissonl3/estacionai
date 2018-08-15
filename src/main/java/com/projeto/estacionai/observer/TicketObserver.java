package com.projeto.estacionai.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class TicketObserver {
	
	@Autowired
	protected TicketSujeito ess;
	 
    public TicketObserver(TicketSujeito ess) {
        this.ess = ess;
    }
	
	public abstract void atualizar();

}
