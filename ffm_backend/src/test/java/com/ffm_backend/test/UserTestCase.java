package com.ffm_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ffm_backend.dao.UserDAO;
import com.ffm_backend.dto.User;
import com.ffm_backend.util.ffmUtil;

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
	
}
