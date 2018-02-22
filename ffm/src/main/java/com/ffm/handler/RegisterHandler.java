package com.ffm.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.ffm.model.RegisterModel;
import com.ffm_backend.dao.UserDAO;
import com.ffm_backend.dto.Address;
import com.ffm_backend.dto.Apply;
import com.ffm_backend.dto.User;

@Component
public class RegisterHandler {


/* @Autowired
 private PasswordEncoder passwordEncoder;*/
	
	
 @Autowired
 private UserDAO userDAO;
 public RegisterModel init() { 
  return new RegisterModel();
 } 
 public void addUser(RegisterModel registerModel, User user) {
  registerModel.setUser(user);
 } 
 public void addaddress(RegisterModel registerModel, Address address) {
  registerModel.setaddress(address);
 }

 public String validateUser(User user, MessageContext error) {
  String transitionValue = "success";
   /*if(!user.getPassword().equals(user.getConfirmPassword())) {
    error.addMessage(new MessageBuilder().error().source(
      "confirmPassword").defaultText("Password does not match confirm password!").build());
    transitionValue = "failure";    
   }  
   if(userDAO.getByEmail(user.getEmail())!=null) {
    error.addMessage(new MessageBuilder().error().source(
      "email").defaultText("Email address is already taken!").build());
    transitionValue = "failure";
   }*/
  return transitionValue;
 }
 
 public String saveAll(RegisterModel registerModel) {
  String transitionValue = "success";
  User user = registerModel.getUser();
  if(user.getRole().equals("USER")) {
   // create a new Apply
   Apply Apply = new Apply();
   Apply.setUser(user);
   user.setApply(Apply);
  }
   
  // encode the password
  //user.setPassword(passwordEncoder.encode(user.getPassword()));
  
  // save the user
  userDAO.add(user);
  // save the address address
  Address address = registerModel.getaddress();
 /* address.setu
  address.setUserId(user.getId());
  address.setaddress(true);  */
  userDAO.addAddress(address);
  return transitionValue ;
 } 
}

