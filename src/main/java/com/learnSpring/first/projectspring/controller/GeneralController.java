package com.learnSpring.first.projectspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "name", "password", "other" })

/*
 * No importa si toda la logica esta en un controlador, cuando se quieren
 * preservar los valores del model entre los diferentes request del flujo, Es
 * decir los valores del model enlazados desde una vista; poder ser vistos desde
 * un metodo que mapee otra solicitud desde esa propia vista y sin que los datos
 * se envien un formulario, se utiliza la anotacion
 * 
 * @SessionAttributes ya que cada jsp tiene su propio estado (stateless) por lo
 * cual entre las diferentes vistas no se presevan los valores del model por
 * default
 */
public class GeneralController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submitLoginPage(@RequestParam(required = true) String name, @RequestParam String password,
			@RequestParam String other, ModelMap model) {
		model.put("name", name);
		model.put("password", password);
		model.put("other", other);
		return "template";
	}

	@RequestMapping(value = "/another", method = RequestMethod.GET)
	public String showAnotherPage() {
		return "another"; // Se solicita la vista sin enviarsen los parametros name password y other, pero
							// como son atributos de session se pueden ver desde cualquier vista
	}

}
