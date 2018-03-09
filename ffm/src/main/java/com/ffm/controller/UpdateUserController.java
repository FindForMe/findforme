package com.ffm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ffm.util.FileUtil;
import com.ffm_backend.dao.UserDAO;
import com.ffm_backend.dto.Address;
import com.ffm_backend.dto.Company;
import com.ffm_backend.dto.Education;
import com.ffm_backend.dto.Experience;
import com.ffm_backend.dto.User;

@Controller
@RequestMapping("/update")
public class UpdateUserController {

	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value = "/{id}/personal", method = RequestMethod.POST )
	public String updateUserProfile(@Valid @PathVariable int id ,@ModelAttribute("user") User  mUser, BindingResult result, Model model, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			model.addAttribute("message","Profile Not Updated");
			model.addAttribute("userClickShowUser",true);
			return "page";
		}
		userDAO.updateUser(mUser);
		
		//uploading user image
		if(mUser.getFile().getOriginalFilename().equals("")) {
			FileUtil.uploadProfilePicture(request, mUser.getFile(), String.valueOf(mUser.getId()));
		}
		
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
	@RequestMapping(value = "/{id}/experience", method = RequestMethod.POST)
	public String updateExperience(@PathVariable int id, @ModelAttribute("nExperience") Experience experience) {
		
		if(experience.getId() == 0) {
			userDAO.addExperience(experience);
		}else {
			userDAO.updateExperience(experience);
		}
		
		return "redirect:/show/"+id+"/user?success=personal";
	}
	@RequestMapping(value = "/{id}/company", method = RequestMethod.POST)
	public String updateCompany(@PathVariable int id, @ModelAttribute("nCompany") Company company) {
		
		if(company.getId() == 0) {
			userDAO.addCompany(company);
		}else {
			userDAO.updateCompany(company);
		}
		
		return "redirect:/show/"+id+"/user?success=personal";
	}
	
	/*
	 * delete experience based on id
	 */
	@RequestMapping(value = "{id}/experience/{experienceId}/delete")
	public String deleteExperience(@PathVariable("experienceId") int experienceId, @PathVariable int id ) {
		
		userDAO.deleteExperience(experienceId);
		
		return "redirect:/show/"+id+"/user?success=delete"; 
	}
	
	/*
	 * delete company based on id
	 */
	@RequestMapping(value = "{id}/company/{companyId}/delete")
	public String deleteCompany(@PathVariable("companyId") int companyId, @PathVariable int id ) {
		
		userDAO.deleteCompany(companyId);
		
		return "redirect:/show/"+id+"/user?success=delete"; 
	}
}
