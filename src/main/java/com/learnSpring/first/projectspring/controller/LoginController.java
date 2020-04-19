package com.learnSpring.first.projectspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping("/login") //Mapea la solicitud /login al metodo logginMessage
	// @ResponseBody ya no enviara directamente al cliente la resuesta sino buscara una vista	
	/**
	 * 
	 * @param name: Parametro que se recupera de la solicitud 
	 * @param model: El modelo es utilizado para poder enlazar datos del modelo a la vista 
	 */
	
	public String logginMessage(@RequestParam(required = false) String name, ModelMap model) {
		model.put("name", name);
		return "login"; //el ViewResolver intentara buscar una vista con nombre login
	}

}
