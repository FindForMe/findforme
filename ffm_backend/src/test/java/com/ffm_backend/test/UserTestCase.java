package com.ffm_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ffm_backend.dao.UserDAO;
import com.ffm_backend.dto.Address;
import com.ffm_backend.dto.User;

public class UserTestCase {

	//User user;
	private static UserDAO userDAO;
	private static AnnotationConfigApplicationContext context;
	
	
	@BeforeClass
	public static void init() {
		 context = new AnnotationConfigApplicationContext();
		 context.scan("com.ffm_backend");
		 context.refresh();
		 userDAO = (UserDAO)context.getBean("userDAO");
	}

	/*@Test
	public void addTest() {
		User user = new User();
		user.setUserId("mukeem789");
		user.setPassword("mak@ffm1");
		user.setConfirmPassword("mak@ffm1");
		user.setRole("admin");
		user.setCreated(ffmUtil.genCurrDateTime());
		user.setRowId(ffmUtil.genRowID());
		
		//assertEquals("user add test",true,userDAO.addUser(user));
	}*/
	/*
	@Test
	public void addTest() {
		User user = new User();
		user.setFirstName("mak");
		user.setLastName("Falak");
		user.setRole("USER");
		user.setPassword("mak@ffm1");
		user.setContactNumber("9953504202");
		user.setCreated(ffmUtil.genCurrDateTime());
		user.setRowId(ffmUtil.genRowID());
		user.setEmail("mak@ffm.com");
		if(user.getRole().equals("ADMIN")) {
			Apply apply = new Apply();
			apply.setUser(user);
			user.setApply(apply);
		}
		
		assertEquals("user add test",true,userDAO.addUser(user));
		
		user = new User();
		user.setFirstName("mak1");
		user.setLastName("Falak1");
		user.setRole("USER");
		user.setPassword("mak@ffm1");
		user.setContactNumber("9999999999");
		user.setCreated(ffmUtil.genCurrDateTime());
		user.setRowId(ffmUtil.genRowID());
		user.setEmail("mak@ffm1.com");
		if(user.getRole().equals("USER")) {
			Apply apply = new Apply();
			apply.setUser(user);
			user.setApply(apply);
		}
		 
		assertEquals("user add test",true,userDAO.addUser(user));
	}*/
/*	
	@Test
	public void addAddressTestCase() {
	
		
		Address address = new Address();
		address.setAddressLineOne("sector 18");
		address.setAddressLineTwo("sarhaul");
		address.setCity("gurgaon");
		address.setState("hariyana");
		address.setCountry("india");
		address.setPostalCode("122001");
		//address.setPermanentAddress(true);
		address.setPresentAddress(true);
		User user = userDAO.getUserByEmail("mak@ffm.com");
		User user1 = userDAO.getUserById(4);
		address.setUserId(user.getId());
		
		assertEquals("Faild to add address",true, userDAO.addAddress(address));
		
		assertEquals("failed to featch current ", 3, userDAO.getPermanentAddress(user.getId()).getUserId());

		
		assertEquals("failed to featch permanent ", 4, userDAO.getPermanentAddress(user1.getId()).getUserId());
		
	}*/
	/*@Test
	public void getUserByEmailTest() {
		
		assertEquals("failed to featch user",3, userDAO.getUserByEmail("mak@ffm.com").getId());
	}*/
	
	/*@Test
	public void getPermantentTest() {
		assertEquals("failed to featch permanet ", 3, userDAO.getCurrentAddress(3).getUserId());
	}*/
	
	/*@Test
	public void getCurrentTest() {
		assertEquals("failed to featch current ", 4, userDAO.getPermanentAddress(4).getUserId());
	}*/
	
	
	/*@Test
	public void getAddressList() {
		assertEquals("failed to featch address list ", 1, userDAO.getListAddressByUserId(4).size());
	}*/
}
