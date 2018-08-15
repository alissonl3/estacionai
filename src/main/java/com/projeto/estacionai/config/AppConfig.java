package com.projeto.estacionai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.projeto.estacionai.observer.EntradaSaidaObserver;
import com.projeto.estacionai.observer.TicketSujeito;
import com.projeto.estacionai.service.HistoricoEntradaSaidaServiceObserver;

@Configuration
public class AppConfig {
	
	
	@Bean
	public TicketSujeito ticketSujeito()
	{
		return new TicketSujeito();
	}
	
	@Bean
	public HistoricoEntradaSaidaServiceObserver historicoEntradaSaidaServiceObserver()
	{
		return new HistoricoEntradaSaidaServiceObserver();
	}
	
	
	@Bean
	public EntradaSaidaObserver entradaSaidaObserver()
	{
		return new EntradaSaidaObserver(ticketSujeito());
	}

}
