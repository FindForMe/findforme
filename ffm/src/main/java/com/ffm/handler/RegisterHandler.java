package com.ffm.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ffm.model.RegisterModel;
import com.ffm_backend.dao.UserDAO;
import com.ffm_backend.dto.Address;
import com.ffm_backend.dto.Apply;
import com.ffm_backend.dto.User;

@Component
public class RegisterHandler {

	@Autowired
	UserDAO userDAO;
	@Autowired
	 private PasswordEncoder passwordEncoder;
	
	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
	public void addAddress(RegisterModel registerModel, Address address) {
		registerModel.setAddress(address);
	}
	
	//validate user
	
	Logger logger = LoggerFactory.getLogger(RegisterHandler.class);
	
	public String validateUser(User user, MessageContext error) {
		String transitionValue = "success";
		
		//validation for confirm password
		if(!(user.getPassword().equals(user.getConfirmPassword()))) {
			
			error.addMessage(new MessageBuilder().error().source("confirmPassword")
					.defaultText("Password does not match with confirm password").build()
					);
			transitionValue = "failure";
		}
		
		//checking uniqueness of email
		if(userDAO.getUserByEmail(user.getEmail()) != null) {
			logger.info("email aleardy taken");
			error.addMessage(new MessageBuilder().error().source("email")
					.defaultText("Email address is already taken!").build()
					);
			transitionValue = "faliure";
		}
		
		return transitionValue;
	}
	
	public String saveAll(RegisterModel model) {
		String transitionValue = "success";
		
		User user = model.getUser();
		
		// mapping with apply table
		if(user.getRole().equalsIgnoreCase("SEEKER")) {
			Apply apply = new Apply();
			apply.setUser(user);
			user.setApply(apply);
		}
		
		 // encode the password
		  user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		userDAO.addUser(user);
		
		//setting address 
		
		Address address = model.getAddress();
		address.setUserId(user.getId());
		address.setPermanentAddress(true);
		
		userDAO.addAddress(address);
		
		return transitionValue;
	}
	
}

