package com.projeto.estacionai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
*
* @author Gui
*/
@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping
	public ModelAndView index()
	{		
		ModelAndView mv = new ModelAndView("login/v-login");
		return mv;
	}
}
