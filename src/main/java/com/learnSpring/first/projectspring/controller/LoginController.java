package com.learnSpring.first.projectspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginsSer;

	@RequestMapping(value = "/login", method = RequestMethod.GET) // Mapea la solicitud /login al metodo logginMessage
	// @ResponseBody ya no enviara directamente al cliente la resuesta sino buscara
	// una vista
	/**
	 * 
	 * @param name:  Parametro que se recupera de la solicitud
	 * @param model: El modelo es utilizado para poder enlazar datos del modelo a la
	 *               vista
	 */

	public String logginMessage() {
		return "login"; // el ViewResolver intentara buscar una vista con nombre login
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submitCredencials(@RequestParam String name, @RequestParam String password, ModelMap model) {

		if (loginsSer.validate(password) == false) {
			model.put("errorMessage", "Credenciales Invalidas");
			return "login";
		} else {
			model.put("name", name);
			model.put("password", password);
			return "welcome";

		}

	}

	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public String showClientsPost(@RequestParam String name, @RequestParam String password, ModelMap model) {
		model.put("name", name);
		model.put("password", password);
		return "clients";
	}

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public String showClientsGet() {
		return "clients";
	}

}

@Component
class LoginService {

	boolean validate(String pass) {
		return pass.equalsIgnoreCase("12");
	}
}