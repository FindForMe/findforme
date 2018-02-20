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
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public static List<Category> list = new ArrayList<>();
	public static List<Category> categories = new ArrayList<>();

	
	/*static {
		Category category = new Category();
		category.setId(1);
		category.setName("Mobile");
		category.setDescription("this is Description for mobile");
		category.setImgURL("cat_1.jpg");
		list.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("Laptop");
		category.setDescription("this is Description for laptop");
		category.setImgURL("cat_2.jpg");
		list.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Talevision");
		category.setDescription("this is Description for Talevision");
		category.setImgURL("cat_3.jpg");
		list.add(category);
		
	}*/
	
	@Override
	public Category get(int id) {
		
		//Category category = new Category();
		
			return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		
		/*try {
			category = sessionFactory.getCurrentSession()
					.createQuery("from Category where id=:n")
					.getResultList()
			
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
	}
	
	@Override
	public List<Category> list() {
		try {
		return sessionFactory.getCurrentSession()
					.createQuery("from category",Category.class)
						.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public boolean add(Category category) {
		
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Category category) {
		
		try {
			sessionFactory.getCurrentSession()
			.update(category);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Category category) {
		
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	
	
	
	

}
