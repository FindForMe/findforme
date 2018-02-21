package com.ffm_backend.dao;

import java.util.List;

import com.ffm_backend.dto.Address;
import com.ffm_backend.dto.User;

public interface UserDAO {

	/*
	List<User> list();
	User getUserById(int id);
	boolean addUser(User user);
	boolean updateUser(User user);
	boolean deleteUser(User user);
	*/
	
	User getByEmail(String email);
	User get(int id);

	boolean add(User user);
	
	// adding and updating a new address
	Address getAddress(int addressId);
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	
}
