package com.ffm.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundExcetption() {
		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "The Page Not Constructed");
		mv.addObject("errorDescription", "The Page You are Looking is no longer available Now...");
		mv.addObject("title", "404 Error Page");

		return mv;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {

		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Contact Your Administrator");
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace();
		mv.addObject("errorDescription", sw.toString());
		return mv;
	}
}
