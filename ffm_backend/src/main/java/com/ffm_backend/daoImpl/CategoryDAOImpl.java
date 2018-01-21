package com.ffm_backend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ffm_backend.dao.CategoryDAO;
import com.ffm_backend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory factory;
	
	public static List<Category> list = new ArrayList<>();
	public static List<Category> categories = new ArrayList<>();

	
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
		
		Category category = new Category();
		category.setName("Laptop");
		category.setDescription("this is description for Laptop");
		category.setImgageUrl("img");
		
		
		
		return categories;
	}
	
	@Override
	@Transactional
	public boolean add(Category category) {
		
		try {
			factory.getCurrentSession().persist(category);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	

}
