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

	
	@Override
	public Category get(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Category> list() {
		
		String selectQuery = "FROM Category";
		try {
		return sessionFactory.getCurrentSession()
					.createQuery(selectQuery,Category.class)
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
