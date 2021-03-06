package com.ffm_backend.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ffm_backend.dao.PostDAO;
import com.ffm_backend.dto.Post;
import com.ffm_backend.util.ffmUtil;

public class PostTestCase {

	private static PostDAO postDAO;
	private Post post;
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ffm_backend");
		context.refresh();
		postDAO = (PostDAO) context.getBean("postDAO");
		
	}
	
	/*@Test
	public void add() {
		post = new Post();
		
		post.setTitle("title1");
		post.setCategoryId(1);
		
		//post.code("imgage1.jpg");
		post.setDescription("this is description of title1");
		post.setUserId(1);
		post.setRowId(ffmUtil.genRowID());
		
		assertEquals("added a post in data base", true, postDAO.add(post));
		
	}*/
	
	
	
	/*@Test
	public void getTest() {
		
		assertEquals("getting data from post",1,postDAO.get(1).getId());
		
	}*/
	
	/*@Test
	public void updateTest() {
		post = postDAO.get(1);
		post.setRowId(ffmUtil.genRowID());
		assertEquals("updating post ",true, postDAO.update(post));
	}*/
	
	@Test
	public void getListTest() {
		assertEquals("getting list of post",1,postDAO.list().size());
	}
	
	/*@Test
	public void getCategoryPostTest() {
		assertEquals("failed to get categorypost", 1, postDAO.getPostByCategoryId(1).size());
	}*/
	/*@Test
	public void getPostInterestTest() {
		assertEquals("failed to get categorypost", 4, postDAO.getPostByInterest(3).size());
	}*/
	
}
