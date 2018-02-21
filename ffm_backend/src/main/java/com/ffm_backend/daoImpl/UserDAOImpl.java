package com.ffm_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ffm_backend.dao.UserDAO;
import com.ffm_backend.dto.Address;
import com.ffm_backend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Address getAddress(int addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAddress(Address address) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAddress(Address address) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Address getBillingAddress(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> listShippingAddresses(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
