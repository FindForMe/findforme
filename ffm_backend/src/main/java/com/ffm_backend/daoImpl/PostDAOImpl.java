package com.ffm_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ffm_backend.dao.PostDAO;
import com.ffm_backend.dto.Post;

@Repository("postDAO")
@Transactional
public class PostDAOImpl implements PostDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean add(Post post) {
		try {
			sessionFactory.getCurrentSession().persist(post);
			return true;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Post get(int id) {
		
		try {
			return sessionFactory.getCurrentSession().get(Post.class, Integer.valueOf(id));
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Post> list() {
		
		try {
			
			return sessionFactory.getCurrentSession()
					.createQuery("FROM post",Post.class)
					.getResultList();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Post> getPostByCategoryId(int categoryId ){
		String queryString = "FROM post where categoryId =:categoryId";
		return sessionFactory.getCurrentSession()
				.createQuery(queryString)
				.setParameter("categoryId",categoryId)
				.getResultList();
	}

	
	
	@Override
	public boolean update(Post post) {
	
		try {
			sessionFactory.getCurrentSession().update(post);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Post post) {
	
		try {
			sessionFactory.getCurrentSession().delete(post);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean deActive(Post post) {
		
		post.setActive(false);
		return update(post);
		
	}
	
	
}
