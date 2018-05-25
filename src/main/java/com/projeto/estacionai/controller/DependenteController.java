package com.projeto.estacionai.controller;

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

import com.projeto.estacionai.model.Dependente;
import com.projeto.estacionai.repository.DependenteRepositorySearch;
import com.projeto.estacionai.service.ClienteService;
import com.projeto.estacionai.service.DependenteService;

@Controller
@RequestMapping("/dependentes")
public class DependenteController {
		
		@Autowired
		private DependenteService service;
		@Autowired
		private ClienteService serviceCliente;
		@Autowired
		private DependenteRepositorySearch search;
		
		@GetMapping
		public ModelAndView listar(Dependente filtro)
		{
			
			ModelAndView mv = new ModelAndView("dependentes/v-lista-dependente");
			if((filtro.getCpf() == null || filtro.getCpf().trim().equals("")) && 
				(filtro.getEmail() == null || filtro.getEmail().trim().equals("")) && 
				(filtro.getNome() == null || filtro.getNome().trim().equals("")) && 
				(filtro.getTelefone() == null || filtro.getTelefone().trim().equals("")) &&
				(filtro.getClienteAssociado() == null || filtro.getClienteAssociado().getId() == 0 )) 
			{
				mv.addObject("dependentes", service.buscarTodos());
				mv.addObject("associados", serviceCliente.buscarTodos());
				mv.addObject("filtro", new Dependente());
			}
			else
			{
				
				mv.addObject("dependentes", search.filtrar(filtro));
				mv.addObject("associados", serviceCliente.buscarTodos());
				mv.addObject("filtro", filtro);
			}
			return mv;
		}
		
		@PostMapping
		public ModelAndView listarEspecifico(Dependente filtro)
		{
			return listar(filtro);
		}
		
		
		
		@GetMapping("/novo")
		public ModelAndView novo(Dependente dependente)
		{
			ModelAndView mv = new ModelAndView("dependentes/v-cadastro-dependente");
			mv.addObject(dependente);
			mv.addObject("associados", serviceCliente.buscarTodos());
			return mv;
		}
		
		@GetMapping("/editar/{id}")
		public ModelAndView editar(@PathVariable Long id)
		{
			return novo(service.buscar(id));
		}
		
		@DeleteMapping("/{id}")
		public String deletar(@PathVariable Long id, RedirectAttributes attributes)
		{
			service.deletar(id);
			
			attributes.addFlashAttribute("mensagem", "Dependente removido com sucesso!");
			
			return "redirect:/dependentes";
		}
		
		@PostMapping("/novo")
		public ModelAndView salvar(@Valid Dependente dependente, BindingResult result, RedirectAttributes attributes)
		{
			if(result.hasErrors())
			{
				return novo(dependente);
			}
			
			
				
			if(dependente.getId() == null)
			{
				
				service.salvar(dependente);
				
				attributes.addFlashAttribute("mensagem", "Dependente cadastrado com sucesso!");
				
				return new ModelAndView("redirect:/dependentes/novo");
			}
			else
			{
				
				service.salvar(dependente);
				
				attributes.addFlashAttribute("mensagem", "Dependente atualizado com sucesso!");
				
				return new ModelAndView("redirect:/dependentes/editar/" + dependente.getId());
			}
		}


	}
