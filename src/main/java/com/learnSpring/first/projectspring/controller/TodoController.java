package com.learnSpring.first.projectspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learnSpring.first.projectspring.springboot.web.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService todoService;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showListTodos(ModelMap model) {
		String namefromLogin = (String) model.get("name");
		System.out.println(namefromLogin);
		model.put("todos", todoService.retrieveTodos(namefromLogin));
		return "list-todos";
	}

}
