package com.learnSpring.first.projectspring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learnSpring.first.projectspring.springboot.web.model.Todo;
import com.learnSpring.first.projectspring.springboot.web.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showListTodos(ModelMap model) {
		String namefromLogin = (String) model.get("name");
		model.put("todos", todoService.retrieveTodos(namefromLogin));
		return "list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodo(ModelMap model) {

		// Crea un Objeto bean de defecto para que se enlace al formulario por medio del
		// commandName, por lo cual los valores que se llenen aca se veran reflejados en
		// los valores por defecto del formulario
		model.addAttribute("todo", new Todo(0, (String) model.get("name"), "", new Date(), false));
		//model.put("todo", new Todo(0, (String) model.get("name"), "Miremos si enlaza", new Date(), false));
		
		//la diferencia entre put and addAttribute es la validacion no NUll de addTributte
		return "add-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "add-todos";
		}
		
		String namefromLogin = (String) model.get("name");
		todoService.addTodo(namefromLogin, todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam(required = true) int id) {
		todoService.deleteTodo(id);
		return "redirect:list-todos";
	}

	

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam(required = true) int id, ModelMap model) {
		Todo setTodo = todoService.retrieveTodo(id);
		model.put("todo",setTodo);
		return "add-todos";
	}
	
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			return "add-todos";
		}
		todo.setUser((String)model.get("name"));
		todo.setTargetDate(new Date());
		System.out.println(todo);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	
}


