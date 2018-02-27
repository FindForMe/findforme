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
	public User getUserByEmail(String email) {
		String selectQuery = "FROM user WHERE email=:email";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery,User.class)
					.setParameter("email", email)
					.getSingleResult();
					
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public User getUserById(int id) {
	
		try {
			return sessionFactory.getCurrentSession().get(User.class, Integer.valueOf(id));
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addUser(User user) {
		
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Address getAddressById(int addressId) {
		try {
			return sessionFactory.getCurrentSession().get(Address.class, addressId);
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean addAddress(Address address) {

		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().update(address);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	
	}

	@Override
	public List<Address> getListAddressByUserId(int userId) {

		String selectQuery = "FROM address WHERE userId = :userId";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, Address.class)
					.setParameter("userId", userId)
					.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getPermanentAddress(int userId) {
		String selectQuery = "FROM address WHERE userId = :userId AND permanentAddress = :permanentAddress";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery,Address.class)
					.setParameter("userId", userId)
					.setParameter("permanentAddress", true)
					.getSingleResult();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getCurrentAddress(int userId) {
		String selectQuery = "FROM address WHERE userId = :userId AND currentAddress = :currentAddress";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery,Address.class)
					.setParameter("userId", userId)
					.setParameter("currentAddress", true)
					.getSingleResult();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	}
