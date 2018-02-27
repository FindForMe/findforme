package com.ffm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ffm.model.UserModel;
import com.ffm_backend.dao.UserDAO;
import com.ffm_backend.dto.User;

@ControllerAdvice
public class GlobalController {
	
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private HttpSession session;
	
	private UserModel userModel = null;
	private User user = null;	
	
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {		
		if(session.getAttribute("userModel")==null) {
			// get the authentication object
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			
			if(!authentication.getPrincipal().equals("anonymousUser")){
				// get the user from the database
				user = userDAO.getUserByEmail(authentication.getName());
				
				if(user!=null) {
					// create a new model
					userModel = new UserModel();
					// set the name and the id
					userModel.setId(user.getId());
					userModel.setFullName(user.getFirstName() + " " + user.getLastName());
					userModel.setRole(user.getRole());
					
					if(user.getRole().equals("USER")) {
						userModel.setApply(user.getApply());					
					}				
	
					session.setAttribute("userModel", userModel);
					return userModel;
				}			
			}
		}
		
		return (UserModel) session.getAttribute("userModel");		
	}
		
}

