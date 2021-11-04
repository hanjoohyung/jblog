package com.douzone.jblog.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.jblog.exception.FileUploadException;
import com.douzone.jblog.security.Auth;
import com.douzone.jblog.security.AuthUser;
import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.service.FileUploadService;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;
import com.douzone.jblog.vo.UserVo;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	private static final Log LOGGER = LogFactory.getLog(BlogController.class);

	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Auth
	@RequestMapping({"" ,"/blog-main","/blog-main/{authUser.id}"})
	public String index(Model model, BlogVo blog, @AuthUser UserVo authUser, @PathVariable("authUser.id") String id, CategoryVo cgvo) {
		blog.setId(id);
		BlogVo vo = blogService.getBlog(blog);
		model.addAttribute("vo", vo);
		cgvo.setBlogId(id);
		List<CategoryVo> list = blogService.findCategory(cgvo);
		model.addAttribute("list", list);
		
		return "blog/blog-main";
	}
	
	@Auth
	@RequestMapping(value="/blog-admin-basic/{authUser.id}", method=RequestMethod.GET)
	public String basic(Model model, BlogVo blog, @PathVariable("authUser.id") String id) {
		blog.setId(id);
		BlogVo vo = blogService.getBlog(blog);
		model.addAttribute("vo", vo);
		
		
		return "blog/blog-admin-basic";
	}
	
	@Auth
	@RequestMapping(value="/update/{authUser.id}", method=RequestMethod.POST)
	public String main(BlogVo blog, @RequestParam("file") MultipartFile file, @AuthUser UserVo authUser,
			@PathVariable("authUser.id") String id) {
		blog.setId(id);
		
		try {
			String logo = fileUploadService.restoreImage(file,blog);
			blog.setLogo(logo);
		} catch(FileUploadException ex) {
			LOGGER.info("Admin Main Update:" + ex);
		}
		
		blogService.update(blog);
		servletContext.setAttribute("blog", blog);
		
		return "redirect:/blog/blog-main/{authUser.id}";
	}	
	
	@Auth
	@RequestMapping(value="/blog-admin-category/{authUser.id}", method=RequestMethod.GET)
	public String category(Model model, BlogVo blog, @PathVariable("authUser.id") String id, CategoryVo cgvo) {
		blog.setId(id);
		BlogVo vo = blogService.getBlog(blog);
		model.addAttribute("vo", vo);
		cgvo.setBlogId(id);
		List<CategoryVo> list = blogService.findCategory(cgvo);
		model.addAttribute("list", list);
		
		return "blog/blog-admin-category";
	}
	@Auth
	@RequestMapping(value="/cateadd/{authUser.id}", method=RequestMethod.POST)
	public String cateadd(Model model, BlogVo blog, @PathVariable("authUser.id") String id, CategoryVo cgvo) {
		cgvo.setBlogId(id);
		
		blogService.addCategory(cgvo);
		
		return "redirect:/blog/blog-main/{authUser.id}";
	}
	
	
	@Auth
	@RequestMapping(value="/blog-admin-write/{authUser.id}", method=RequestMethod.GET)
	public String write(Model model, BlogVo blog, @PathVariable("authUser.id") String id,CategoryVo cgvo) {
		blog.setId(id);
		BlogVo vo = blogService.getBlog(blog);
		model.addAttribute("vo", vo);
		cgvo.setBlogId(vo.getId());
		List<CategoryVo> list = blogService.findCategory(cgvo);
		model.addAttribute("list", list);
		return "blog/blog-admin-write";
	}
	
	@Auth
	@RequestMapping(value="/add/{authUser.id}", method=RequestMethod.POST)
	public String add(Model model, BlogVo blog, @PathVariable("authUser.id") String id, CategoryVo cgvo, PostVo postvo) {
		// postvo.setCategoryNo();
		
		blogService.addPost(postvo);
		
		return "redirect:/blog/blog-main";
	}
}
