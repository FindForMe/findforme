package com.ffm.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ffm.model.UserModel;
import com.ffm_backend.dao.UserDAO;
import com.ffm_backend.dto.User;

public class ffmUtilMain {

	@Autowired
	private static UserDAO userDAO;
	
	
	public static int getUserId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userModel")==null) {
			// get the authentication object
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = null;
			UserModel userModel = null;
			
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
				}			
			}
		}
		
		UserModel userModel = (UserModel)session.getAttribute("userModel");
		if(userModel != null) {
			return userModel.getId();
		}
		return 0;
	}
	public static UserModel getUserModel(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userModel")==null) {
			// get the authentication object
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = null;
			UserModel userModel = null;
			
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
				}			
			}
		}
		
		if(session.getAttribute("userModel") != null) {
			return (UserModel)session.getAttribute("userModel");
		}
		return null;
	}
	
}
