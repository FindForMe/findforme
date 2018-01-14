package com.ffm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","FindForMe");
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
	@RequestMapping(value = "/hire")
	public ModelAndView hire() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Hire Freelancer");
		mv.addObject("userClickHire",true);

		return mv;
	}
	@RequestMapping(value = "/find")
	public ModelAndView find() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Find Work");
		mv.addObject("userClickFind",true);
		return mv;
	}
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
}
