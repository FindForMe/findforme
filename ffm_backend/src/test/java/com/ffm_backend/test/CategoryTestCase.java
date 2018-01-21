package com.ffm_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ffm_backend.dao.CategoryDAO;
import com.ffm_backend.dto.Category;

public class CategoryTestCase {

	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ffm_backend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	@Test
	public void categoryAddTest() {
		
		Category category = new Category();
		category.setName("Mobile");
		category.setDescription("this is Description for mobile");
		category.setImgageUrl("cat_1.jpg");
		
		assertEquals("category list has been added",true, categoryDAO.add(category));
	}
	
}
