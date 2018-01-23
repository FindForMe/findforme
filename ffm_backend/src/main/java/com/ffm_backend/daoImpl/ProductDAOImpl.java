package com.ffm_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ffm_backend.dao.ProductDAO;
import com.ffm_backend.dto.Product;

public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addProduct(Product product) {

		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public Product get(int productId) {

		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Product> listActiveProduct() {
		return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		product.setActive(false);
		try {
			return this.updateProduct(product);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> getListProduct() {
		String selectQuery = "FROM Product";

		return sessionFactory.getCurrentSession().createQuery(selectQuery, Product.class).getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		
		String selectQuery = "FROM Product WHERE active = :active AND cateforyId = :categoryId";
		return sessionFactory.getCurrentSession()
				.createQuery(selectQuery,Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsByParam(String param, int count) {
		// TODO Auto-generated method stub
		return null;
	}

}
