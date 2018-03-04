package com.ffm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ffm.exception.PostNotFoundException;
import com.ffm.exception.UserNotFoundException;
import com.ffm_backend.dao.CategoryDAO;
import com.ffm_backend.dao.PostDAO;
import com.ffm_backend.dao.UserDAO;
import com.ffm_backend.dto.Address;
import com.ffm_backend.dto.Category;
import com.ffm_backend.dto.Education;
import com.ffm_backend.dto.Post;
import com.ffm_backend.dto.User;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	PostDAO postDAO;
	@Autowired
	UserDAO userDAO;
	
	
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
		mv.addObject("title","All Post");
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
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("category",category);
		
		mv.addObject("userClickCategoryPost",true);
		return mv;
	}
	
	@RequestMapping(value = "/show/{id}/post")
	public ModelAndView showSinglePost(@PathVariable int id)throws PostNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		Post post = postDAO.get(id);
		if(post == null) throw new PostNotFoundException();
		//update the view 
		post.setView(post.getView()+1);
		postDAO.update(post);
		mv.addObject("title",post.getId());
		mv.addObject("post",post);
		mv.addObject("userClickSinglePost",true);
		
		return mv;
	}
	
	//adding profile view
	
	@RequestMapping(value = "/show/{id}/user")
	public ModelAndView getUserProfile(@RequestParam(name = "success",required = false) String success,@PathVariable int id) throws UserNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		
		logger.info("id "+id);
		User user = userDAO.getUserById(id);
		if(user == null) throw new UserNotFoundException();
		mv.addObject("user",user);
		List<Address> listAddress = userDAO.getListAddressByUserId(id);
		logger.info("-------------------address list---------------\n"+listAddress);
		Address pAddress = null,cAddress = null, comAddress = null;
		for(Address address : listAddress) {
			if(address.isPermanentAddress() == true) {
				pAddress = address;
			}else if(address.isCurrentAddress() == true) {
				cAddress = address;
			}else {
				
			}
		}
		
		if(pAddress == null) {
			logger.info("pAddress is null");
			pAddress = new Address();
		}
		if(cAddress == null) {
			logger.info("cAddress is null");
			cAddress = new Address();
		}
		
		mv.addObject("pAddress",pAddress);
		mv.addObject("cAddress",cAddress);
		
		Education education = userDAO.getEducationByUserId(id);
		if(education == null) {
			education = new Education();
		}
		mv.addObject("education",education);
		mv.addObject("experience",userDAO.getExperienceList(id));
		mv.addObject("title",user.getFirstName()+" "+user.getLastName());
		mv.addObject("userClickShowUser",true);
		if(success != null) {

			if(success.equals("personal")) {
				mv.addObject("message","Profile Updated Successfully");
			}
		}
		
		
		
		return mv;
	}
	
	
	
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(name="error", required = false)	String error,
			@RequestParam(name="logout", required = false) String logout) {
		ModelAndView mv= new ModelAndView("login");
		mv.addObject("title", "Login");
		if(error!=null) {
			mv.addObject("message", "Username and Password is invalid!");
		}
		if(logout!=null) {
			mv.addObject("logout", "You have logged out successfully!");
		}
		return mv;
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		// Invalidates HTTP Session, then unbinds any objects bound to it.
	    // Removes the authentication from securitycontext 		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		
		return "redirect:/login?logout";
	}	
	
	
	@RequestMapping(value="/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");		
		mv.addObject("errorTitle", "Aha! Caught You.");		
		mv.addObject("errorDescription", "You are not authorized to view this page!");		
		mv.addObject("title", "403 Access Denied");		
		return mv;
	}	
		
	
	
	
	
	
	
	
}
