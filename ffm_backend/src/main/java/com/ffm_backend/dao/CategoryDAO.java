package com.ffm_backend.dao;

import java.util.List;

import com.ffm_backend.dto.Category;

public interface CategoryDAO {
	
	Category get(int id);
	List<Category> list();
}
