/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.estacionai.controller;

import com.projeto.estacionai.service.ContaEquipamentoService;
import com.projeto.estacionai.service.ContaPagarService;
import com.projeto.estacionai.service.ContaReceberService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Alisson
 */
@Controller
@RequestMapping("/relatorios")
public class RelatorioController {
	
	@Autowired
	private ContaPagarService servicePagar;
	@Autowired
	private ContaReceberService serviceReceber;
	@Autowired
	private ContaEquipamentoService serviceEquipamento;
	
	
	@GetMapping("/pagar")
	public ModelAndView index()
	{		
		
		ModelAndView mv = new ModelAndView("relatorios/pagar/v-relatorio");
		mv.addObject("contas", servicePagar.buscarTodos());
		mv.addObject("total", servicePagar.total());
		return mv;
	}
	
	@GetMapping("/receber")
	public ModelAndView indexReceber()
	{		
		
		ModelAndView mv = new ModelAndView("relatorios/receber/v-relatorio");
		mv.addObject("contas", serviceReceber.buscarTodos());
		mv.addObject("total", serviceReceber.total());
		return mv;
	}
	
	@GetMapping("/movimento")
	public ModelAndView indexMovimento()
	{		
		
		ModelAndView mv = new ModelAndView("relatorios/movimento/v-relatorio");
		mv.addObject("contas", serviceReceber.buscarTodos());
		mv.addObject("total", serviceReceber.total());
		return mv;
	}
	
	
	@GetMapping("/equipamento")
	public ModelAndView indexEquipamento()
	{		
		
		ModelAndView mv = new ModelAndView("relatorios/equipamento/v-relatorio");
		mv.addObject("contas", serviceEquipamento.buscarTodos());
		return mv;
	}
	
	

}
