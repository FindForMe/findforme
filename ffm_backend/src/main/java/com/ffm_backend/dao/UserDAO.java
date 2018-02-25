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
	
	User getUserByEmail(String email);
	User getUserById(int id);

	boolean addUser(User user);
	
	// adding and updating a new address
	Address getAddressById(int addressId);
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	List<Address> getListAddressByUserId(int userid);
	Address getPermanentAddress(int userid);
	Address getCurrentAddress(int userid);
	
	
}
