package com.ffm_backend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ffm_backend.dao.CategoryDAO;
import com.ffm_backend.dto.Category;

@Repository("catgoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	public static List<Category> list = new ArrayList<>();
	
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Mobile");
		category.setDescription("this is Description for mobile");
		category.setImgageUrl("cat_1.jpg");
		list.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("Laptop");
		category.setDescription("this is Description for laptop");
		category.setImgageUrl("cat_2.jpg");
		list.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Talevision");
		category.setDescription("this is Description for Talevision");
		category.setImgageUrl("cat_3.jpg");
		list.add(category);
		
	}
	
	@Override
	public Category get(int id) {
		return this.list().get(id);
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return list;
	}
	
	
	

}
