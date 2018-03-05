package com.ffm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ffm_backend.dao.UserDAO;
import com.ffm_backend.dto.Address;
import com.ffm_backend.dto.Education;
import com.ffm_backend.dto.User;

@Controller
@RequestMapping("/update")
public class UpdateUserController {

	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value = "/{id}/personal", method = RequestMethod.POST )
	public String updateUserProfile(@Valid @PathVariable int id ,@ModelAttribute("user") User  mUser, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("message","Profile Not Updated");
			model.addAttribute("userClickShowUser",true);
			return "page";
		}
		userDAO.updateUser(mUser);
		
		return "redirect:/show/"+id+"/user?success=personal";
	}
	
	@RequestMapping(value = "/{id}/pAddress", method = RequestMethod.POST )
	public String updatePermanentAddress(@Valid @PathVariable int id ,@ModelAttribute("pAddress") Address  pAddress, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("message","Profile Not Updated");
			model.addAttribute("userClickShowUser",true);
			return "page";
		}
		pAddress.setPermanentAddress(true);
		if(pAddress.getId() == 0) {
			
			userDAO.addAddress(pAddress);
		}else {
			userDAO.updateAddress(pAddress);
		}
		return "redirect:/show/"+id+"/user?success=personal";
	}
	
	@RequestMapping(value = "/{id}/cAddress", method = RequestMethod.POST )
	public String updateCurrentAddress(@Valid @PathVariable int id ,@ModelAttribute("cAddress") Address  cAddress, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("message","Profile Not Updated");
			model.addAttribute("userClickShowUser",true);
			return "page";
		}
		cAddress.setCurrentAddress(true);
		if(cAddress.getId() == 0) {
			userDAO.addAddress(cAddress);
		}else {
			userDAO.updateAddress(cAddress);
		}
		return "redirect:/show/"+id+"/user?success=personal";
	}
	
	@RequestMapping(value = "/{id}/education", method = RequestMethod.POST)
	public String updateEducation(@PathVariable int id, @ModelAttribute("education") Education education) {
		
		if(education.getId() == 0) {
			userDAO.addEducation(education);
		}else {
			userDAO.updateEducation(education);
		}
		
		return "redirect:/show/"+id+"/user?success=personal";
	}
	
}
