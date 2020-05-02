package com.learnSpring.first.projectspring.springboot.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ErrorController {

	@ExceptionHandler(RuntimeException.class)
	
	public ModelAndView hanldeException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("exception", ex.getStackTrace());
		modelView.addObject("url", request.getRequestURI());
		modelView.setViewName("error");
		return modelView;
	}
}
