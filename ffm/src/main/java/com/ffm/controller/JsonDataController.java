package com.ffm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffm_backend.dao.CategoryDAO;
import com.ffm_backend.dao.PostDAO;
import com.ffm_backend.dto.Category;
import com.ffm_backend.dto.Post;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	PostDAO postDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/all/post")
	@ResponseBody
	public List<Post> getAllPost(){
		return postDAO.list();
	}
	
	@RequestMapping("/category/{id}/post")
	@ResponseBody
	public List<Post> getCategoryPost(@PathVariable int id){
		
		return postDAO.getPostByCategoryId(id);
	}
	
	
	
	@RequestMapping("/test")
	@ResponseBody
	public List<String> getTest(){
	
		List<String> list = new ArrayList<>();
		list.add("test");
		list.add("number");
		list.add("address");
		return list;
	}
	
	@RequestMapping("/all/category")
	@ResponseBody
	public List<Category> getCategory(){
		return categoryDAO.list();
	}
	
	
}
