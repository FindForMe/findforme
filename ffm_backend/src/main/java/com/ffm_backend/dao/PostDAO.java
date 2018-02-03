package com.ffm_backend.dao;

import java.util.List;

import com.ffm_backend.dto.Post;

public interface PostDAO {

	boolean add(Post post);
	
	Post get(int id);
	
	List<Post> list();
	
	boolean update(Post post);
	
	boolean delete(Post post);
	
	boolean deActive(Post post);
}
