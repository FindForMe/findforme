package com.ffm_backend.dao;

import java.util.List;

import com.ffm_backend.dto.Product;

public interface ProductDAO {
	
	boolean addProduct(Product product);
	
	Product get(int productId);
	
	List<Product> getListProduct();
	
	boolean updateProduct(Product product);
	
	boolean deleteProduct(Product product);
	
	List<Product> listActiveProduct();
	
	List<Product> listActiveProductsByCategory(int categoryId);
	
	List<Product> getLatestActiveProducts(int count);
	
	List<Product> getProductsByParam(String param, int count);
}
