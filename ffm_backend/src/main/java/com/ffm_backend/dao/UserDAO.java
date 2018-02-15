package com.ffm_backend.dao;

import java.util.List;

import com.ffm_backend.dto.User;

public interface UserDAO {

	List<User> list();
	User getUserById(int id);
	boolean addUser(User user);
	boolean updateUser(User user);
	boolean deleteUser(User user);
	
}
