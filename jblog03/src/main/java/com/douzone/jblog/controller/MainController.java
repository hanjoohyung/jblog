package com.douzone.jblog.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping({"", "/main"})
	public String index() {

		return "main/index";
	}
}
