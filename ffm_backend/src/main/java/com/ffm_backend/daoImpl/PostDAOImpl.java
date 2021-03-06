package com.ffm_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
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
		
		String queryString = "FROM Post";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(queryString,Post.class)
					.getResultList();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Post> getPostByUserId(int userId) {
		String queryString = "FROM Post where userId =: userId";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(queryString,Post.class)
					.setParameter("userId", userId)
					.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Post> getPostByCategoryId(int categoryId ){
		String queryString = "FROM Post where categoryId =:categoryId";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(queryString,Post.class)
					.setParameter("categoryId",categoryId)
					.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	@Override
	public List<Post> getPostByInterest(int userId){
		/*String queryString = "From post where categoryId = IN (select categoryid from user_interest where userid ="+userId+")";
		try {
			return sessionFactory.getCurrentSession()
			.createQuery(queryString,Post.class)
			.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}*/
		return null;
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
