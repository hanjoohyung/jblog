package com.douzone.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.jblog.security.Auth;
import com.douzone.jblog.service.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@Auth
	@RequestMapping({"", "/blog-main"})
	public String index() {
		return "blog/blog-main";
	}
	
	@Auth
	@RequestMapping("/blog-admin-basic")
	public String basic() {
		return "blog/blog-admin-basic";
	}
	
	@Auth
	@RequestMapping("/blog-admin-category")
	public String category() {
		return "blog/blog-admin-category";
	}
	
	@Auth
	@RequestMapping("/blog-admin-write")
	public String write() {
		return "blog/blog-admin-write";
	}
}
