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

import com.projeto.estacionai.model.Cliente;
import com.projeto.estacionai.repository.ClienteRepositorySearch;
import com.projeto.estacionai.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
		
		@Autowired
		private ClienteService service;
		@Autowired
		private ClienteRepositorySearch search;
		
		@GetMapping
		public ModelAndView listar(Cliente filtro)
		{
			
			ModelAndView mv = new ModelAndView("clientes/v-lista-cliente");
			if((filtro.getCpf() == null || filtro.getCpf().trim().equals("")) && 
				(filtro.getEndereco() == null || filtro.getEndereco().trim().equals("")) && 
				(filtro.getNome() == null || filtro.getNome().trim().equals("")) && 
				(filtro.getTelefone() == null || filtro.getTelefone().trim().equals("")) &&
				(filtro.getNumeroVagas() == null || filtro.getNumeroVagas() < 0) && 
				(filtro.getTipoPagamento() == null || filtro.getTipoPagamento() < 0))
			{
				mv.addObject("clientes", service.buscarTodos());
				mv.addObject("filtro", new Cliente());
			}
			else
			{
				
				mv.addObject("clientes", search.filtrar(filtro));
				mv.addObject("filtro", filtro);
			}
			return mv;
		}
		
		@PostMapping
		public ModelAndView listarEspecifico(Cliente filtro)
		{
			return listar(filtro);
		}
		
		
		
		@GetMapping("/novo")
		public ModelAndView novo(Cliente cliente)
		{
			ModelAndView mv = new ModelAndView("clientes/v-cadastro-cliente");
			mv.addObject(cliente);			
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
			
			attributes.addFlashAttribute("mensagem", "Cliente removido com sucesso!");
			
			return "redirect:/clientes";
		}
		
		@PostMapping("/novo")
		public ModelAndView salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes)
		{
			if(result.hasErrors())
			{
				return novo(cliente);
			}
			
			
				
			if(cliente.getId() == null)
			{
				
				service.salvar(cliente);
				
				attributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso!");
				
				return new ModelAndView("redirect:/clientes/novo");
			}
			else
			{
				
				service.salvar(cliente);
				
				attributes.addFlashAttribute("mensagem", "Cliente atualizado com sucesso!");
				
				return new ModelAndView("redirect:/clientes/editar/" + cliente.getId());
			}
		}


	}
