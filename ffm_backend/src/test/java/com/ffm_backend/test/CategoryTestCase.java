package com.ffm_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
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
	/*@Test
	public void categoryAddTest() {
		
		Category category = new Category();
		category.setName("Mobile");
		category.setDescription("this is Description for Mobile");
		category.setImgageUrl("cat_1.jpg");
		//category.setId(1);
		
		assertEquals("category list has been added",true, categoryDAO.add(category));
	}*/
	
	/*@Test
	public void categoryGetTest() {
		
		category = categoryDAO.get(1);
		assertEquals("fetching result by id","Mobile",category.getName());
		
	}*/
	@Test
	public void categoryListGet() {
		
		assertEquals("fetching the result list ",2, categoryDAO.list().size());
	}
	/*
	@Test
	public void categoryUpdate() {
		
		category  = categoryDAO.get(3);
		
		category.setId(1);
		
		assertEquals("update category",true,categoryDAO.update(category));
	}*/
	
	/*@Test
	public void categoryDelete() {
		
		category  = new Category();
		
		category.setId(1);
		
		assertEquals("update category",true,categoryDAO.delete(category));
	}*/
	
}
