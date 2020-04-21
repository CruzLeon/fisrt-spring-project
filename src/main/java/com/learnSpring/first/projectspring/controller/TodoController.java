package com.learnSpring.first.projectspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learnSpring.first.projectspring.springboot.web.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	TodoService todoService;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showListTodos(ModelMap model) {

		model.put("todos", todoService.retrieveTodos("in28Minutes"));
		return "list-todos";
	}

}
