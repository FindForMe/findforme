package com.ffm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("hello", "Welcome to FFM");
		mv.addObject("title","FindForMe");
		return mv;
	}
	@RequestMapping(value = "/test")
	public ModelAndView test(@RequestParam(value = "hello", required = false)String hello) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("hello", hello);
		mv.addObject("title","FindForMe");
		return mv;
	}
	@RequestMapping(value = "/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("hello", "index page");
		mv.addObject("title","FindForMe");
		return mv;
	}
}
