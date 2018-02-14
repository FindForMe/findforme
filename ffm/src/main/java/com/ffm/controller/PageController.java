package com.ffm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ffm_backend.dao.CategoryDAO;
import com.ffm_backend.dto.Category;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		mv.addObject("title","FindForMe");
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickHome",true);
		return mv;
	}
	@RequestMapping(value = "/test/{hello}")
	public ModelAndView test(@PathVariable(value = "hello")String hello) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","FindForMe");
		mv.addObject("userClickHome",true);
		return mv;
	}
	/*@RequestMapping(value = "/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("hello", "index page");
		mv.addObject("title","FindForMe");
		return mv;
	}*/
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);

		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	@RequestMapping(value = "/show/all/post")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickAllPost",true);
		return mv;
	}
	@RequestMapping(value = "/show/category/{id}/post")
	public ModelAndView showCategoryProducts(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("title",category.getName());
		mv.addObject("category",category);

		mv.addObject("userClickShowPost",true);
		return mv;
	}
	
}
