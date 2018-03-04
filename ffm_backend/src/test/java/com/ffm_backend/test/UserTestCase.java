package com.ffm_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ffm_backend.dao.*;
import com.ffm_backend.dto.Education;

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

/*	@Test
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
	
/*	@Test
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
	}
 	*/
	
		
	/*@Test
	public void addAddressTestCase() {
	
		
		Address address = new Address();
		address.setAddressLineOne("sector 18");
		address.setAddressLineTwo("sarhaul");
		address.setCity("gurgaon");
		address.setState("hariyana");
		address.setCountry("india");
		address.setPostalCode("122001");
		//address.setPermanentAddress(true);
		address.setCurrentAddress(true);
		User user = userDAO.getUserByEmail("mak@ffm.com");
		User user1 = userDAO.getUserById(4);
		address.setUserId(user.getId());
		address.setUserId(3);
		
		assertEquals("Faild to add address",true, userDAO.addAddress(address));
		
		address = new Address();
		address.setAddressLineOne("sector 18");
		address.setAddressLineTwo("sarhaul");
		address.setCity("gurgaon");
		address.setState("hariyana");
		address.setCountry("india");
		address.setPostalCode("122001");
		address.setPermanentAddress(true);
		address.setCurrentAddress(true);
		User user = userDAO.getUserByEmail("mak@ffm.com");
		User user1 = userDAO.getUserById(4);
		address.setUserId(user.getId());
		
		address.setUserId(3);
		assertEquals("Faild to add address",true, userDAO.addAddress(address));
		//assertEquals("failed to featch current ", 3, userDAO.getPermanentAddress(user.getId()).getUserId());
		
		//assertEquals("failed to featch permanent ", 4, userDAO.getPermanentAddress(user1.getId()).getUserId());
		
	}*/
	/*@Test
	public void getUserByEmailTest() {
		
		assertEquals("failed to featch user",1, userDAO.getUserByEmail("mak@ffm.com").getId());
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
	
	
	@Test
	public void testAddEducation() {
		
		Education education = new Education();
		education.setGraduation("b.tech");
		education.setGraducationOther("UPTU");
		education.setGraduationPercentage(78.2);
		education.setGradutaionYear(2016);
		
		education.setIntermediate("RBSIC");
		education.setIntermediateYear(2012);
		education.setIntermediatePercentage(70);
		
		education.setHighSchool("RBSIC");
		education.setHighSchoolPercentage(60);
		education.setHighSchoolYear(2010);
		
		education.setUserId(3);
	
		assertEquals("education add failed",true, userDAO.addEducation(education));
		
	}
	
	/*@Test
	public void getEducation() {
		
		assertEquals("failed to fetch education",3, userDAO.getEducationByUserId(3).getUserId());
		
	}*/
	
	/*@Test
	public void updateEducation() {
		
		Education education = userDAO.getEducationByUserId(3);
		education.setHighSchool("up board");
		assertEquals("failed to fetch education",true, userDAO.updateEducation(education));
		
	}*/
	
	/*@Test
	public void listEducation() {
		
		assertEquals("failed to fetch education",1, userDAO.getEducationList(3).size());
		
	}*/
	
	/*@Test
	public void deleteEducation() {
		
		//assertEquals("failed to delete education",1, userDAO.getEducationList(3).size());
		
	}*/
	
	
	/*
	 * Companay Test
	 */

	/*@Test
	public void addCompany() {
		Company company = new Company();
		company.setUserId(3);
		company.setName("Find For Me");
		company.setDescription("Deals with ffm");
		company.setAddress("Gurgaon");
		
		assertEquals("failed to test company", true, userDAO.addCompany(company));
	}*/
	/*@Test
	public void getCompany() {
		
		assertEquals("failed to test company", 1, userDAO.getCompanyList(3).size());
	}*/
	
	/*@Test
	public void updateCompany() {
		Company company = userDAO.getCompanyById(1);
		company.setDescription("updated ffm");
		assertEquals("failed to test company", true, userDAO.updateCompany(company));
	}*/
	
	
	/*@Test
	public void deleteCompany() {
		
	
		assertEquals("failed to test company", true, userDAO.deleteCompany(3));
	}*/
	
	
}
