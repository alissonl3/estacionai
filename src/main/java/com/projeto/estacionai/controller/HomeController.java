/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.estacionai.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.estacionai.model.Ticket;
import com.projeto.estacionai.model.Veiculo;
import com.projeto.estacionai.observer.EntradaSaidaObserver;
import com.projeto.estacionai.observer.TicketSujeito;
import com.projeto.estacionai.service.TicketService;
import com.projeto.estacionai.service.VeiculoService;

/**
 *
 * @author Alisson
 */
@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private TicketService service;
	@Autowired
	private VeiculoService serviceVeiculo;
	@Autowired
	private TicketSujeito sujeito;
	
	
	@GetMapping
	public ModelAndView index()
	{		
		ModelAndView mv = new ModelAndView("home/v-home");
		return mv;
	}
	
	public ModelAndView index(String erro)
	{		
		
		ModelAndView mv = new ModelAndView("home/v-home");
		mv.addObject("erro", erro);
		return mv;
	}
	
	
	@GetMapping("/observer")
	public ModelAndView iniciarObservadores()
	{
		
		TicketSujeito sujeito = new TicketSujeito();
		sujeito.anexar(new EntradaSaidaObserver(sujeito));	
		
		ModelAndView mv = new ModelAndView("redirect:/");
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
		System.out.println("Entrou no gerar.");
		System.out.println("Valor: " + placa);
		//salvamento do ticket novo
		Veiculo veiculo = this.serviceVeiculo.buscarPorPlaca(placa);
		
		if(veiculo == null)
		{
			System.out.println("Não encontrou veiculo");
			
			attributes.addFlashAttribute("erro", "Veiculo não encontrado. Tente novamente!");
			return new ModelAndView("redirect:/home");
		}
		
		System.out.println("Encontrou veiculo");
		String codigo = "";
		try {
			codigo = DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5").digest(placa.getBytes("utf-8")));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Codigo: " + codigo);
		Ticket ticket = new Ticket();
		ticket.setPlaca(placa);
		ticket.setCodigo(codigo);
		ticket.setAtivo(true);
		ticket.setHorarioChegada(LocalDateTime.now());
		ticket.setHorarioSaida(LocalDateTime.now());
		ticket.setTotal(this.service.calcularTotal(ticket));
		ticket.setCliente(veiculo.getCliente());
		this.service.gerarTicket(ticket);
		
		//alertando os observadores (verificar problema)
//		this.sujeito.anexar(new EntradaSaidaObserver(sujeito));
//		this.sujeito.setarEstado(this.service.buscarUltimo());
		
		
		ModelAndView mv = new ModelAndView("redirect:/clientes");
		return mv;
	}
	

}
