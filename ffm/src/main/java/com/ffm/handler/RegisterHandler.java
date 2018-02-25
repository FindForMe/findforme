package com.ffm.handler;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
	public void addAddress(RegisterModel registerModel, Address address) {
		registerModel.setAddress(address);
	}
	
	public String saveAll(RegisterModel model) {
		String transitionValue = "succcess";
		
		User user = model.getUser();
		
		// mapping with apply table
		if(user.getRole().equalsIgnoreCase("USER")) {
			Apply apply = new Apply();
			apply.setUser(user);
			user.setApply(apply);
		}
		
		userDAO.add(user);
		
		//setting address 
		
		Address address = model.getAddress();
		address.setUserId(user.getId());
		address.setPermanentAddress(true);
		
		userDAO.addAddress(address);
		
		return transitionValue;
	}
	
}

