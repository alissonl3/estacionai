/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.estacionai.controller;

import com.projeto.estacionai.model.Bloco;
import com.projeto.estacionai.model.Vaga;
import com.projeto.estacionai.repository.BlocoRepositorySearch;
import com.projeto.estacionai.service.BlocoService;
import com.projeto.estacionai.service.VagaService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Eduardo
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	
	@GetMapping
	public ModelAndView index()
	{		
		ModelAndView mv = new ModelAndView("home/v-home");
		return mv;
	}
	

}
