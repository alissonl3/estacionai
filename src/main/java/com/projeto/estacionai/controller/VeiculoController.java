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

import com.projeto.estacionai.filter.VeiculoFilter;
import com.projeto.estacionai.model.Veiculo;
import com.projeto.estacionai.service.VeiculoService;

/**
 * 
 * @author ALISSON 
 *
 */

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoService service;
	
	@GetMapping
	public ModelAndView listar(VeiculoFilter filtro)
	{
		
		ModelAndView mv = new ModelAndView("veiculos/v-lista-veiculo");
		if((filtro.getPlaca() == null || filtro.getPlaca().trim().equals("")) && (filtro.getMensalista() == null || filtro.getMensalista().trim().equals("")))
		{
			mv.addObject("veiculos", service.buscarTodos());
			mv.addObject("filtro", new VeiculoFilter());
		}
		else
		{
			
			mv.addObject("veiculos", service.buscarEspecifico(filtro));
			mv.addObject("filtro", filtro);
		}
		return mv;
	}
	
	@PostMapping
	public ModelAndView listarEspecifico(VeiculoFilter filtro)
	{
		return listar(filtro);
	}
	
	
	
	@GetMapping("/novo")
	public ModelAndView novo(Veiculo veiculo)
	{
		ModelAndView mv = new ModelAndView("veiculos/v-cadastro-veiculo");
		mv.addObject(veiculo);
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
		
		attributes.addFlashAttribute("mensagem", "Veiculo removido com sucesso!");
		
		return "redirect:/veiculos";
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Veiculo veiculo, BindingResult result, RedirectAttributes attributes)
	{
		if(result.hasErrors())
		{
			return novo(veiculo);
		}
		
		
			
		if(veiculo.getId() == null)
		{
			
			service.salvar(veiculo);
			
			attributes.addFlashAttribute("mensagem", "Veiculo cadastrado com sucesso!");
			
			return new ModelAndView("redirect:/veiculos/novo");
		}
		else
		{
			
			service.salvar(veiculo);
			
			attributes.addFlashAttribute("mensagem", "Veiculo atualizado com sucesso!");
			
			return new ModelAndView("redirect:/veiculos/editar/" + veiculo.getId());
		}
	}


}
