package com.learnSpring.first.projectspring.springboot.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "name" })
public class WelcomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET) // Mapea la solicitud /login al metodo logginMessage
	// @ResponseBody ya no enviara directamente al cliente la resuesta sino buscara
	// una vista
	/**
	 * 
	 * @param name:  Parametro que se recupera de la solicitud
	 * @param model: El modelo es utilizado para poder enlazar datos del modelo a la
	 *               vista
	 */

	public String showWelcomePage(ModelMap model) {

		model.put("name", getLoggedUserName());
		return "welcome";

	}

	private String getLoggedUserName() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return principal instanceof UserDetails ? ((UserDetails) principal).getUsername() : principal.toString();

	}
}
