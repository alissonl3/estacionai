/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.estacionai.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.estacionai.model.Ticket;
import com.projeto.estacionai.observer.EntradaSaidaObserver;
import com.projeto.estacionai.observer.TicketSujeito;
import com.projeto.estacionai.service.TicketService;

/**
 *
 * @author Alisson
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketService service;
	
	
	@GetMapping("/gerar/{id}")
	public ModelAndView gerar(@PathVariable Long id)
	{		
		ModelAndView mv = new ModelAndView("ticket/v-gerar-ticket");
		mv.addObject("ticket", this.service.buscarTicket(id));
		return mv;
	}
	
	@GetMapping("/validar/{id}")
	public ModelAndView validar(@PathVariable Long id)
	{		
		
		ModelAndView mv = new ModelAndView("ticket/v-validar-ticket");
		mv.addObject("ticket", this.service.buscarTicket(id));
		return mv;
	}
	
	
	@PostMapping("/validar")
	public ModelAndView validarTicket(String placa, BindingResult result, RedirectAttributes attributes)
	{
		
		Ticket ticket = this.service.buscarTicket(placa);
		if(ticket.equals(null))
		{
			
		}
		
		
		TicketSujeito sujeito = new TicketSujeito();
		sujeito.anexar(new EntradaSaidaObserver(sujeito));	
		
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}
	
	@PostMapping("/gerar")
	public ModelAndView gerarTicket(@RequestParam("placa") String placa, RedirectAttributes attributes)
	{
		return null;
	}
	

}
