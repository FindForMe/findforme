package com.ffm_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ffm_backend.dao.UserDAO;
import com.ffm_backend.dto.Address;
import com.ffm_backend.dto.Company;
import com.ffm_backend.dto.Education;
import com.ffm_backend.dto.Experience;
import com.ffm_backend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User getUserByEmail(String email) {
		String selectQuery = "FROM User WHERE email=:email";
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

		String selectQuery = "FROM Address WHERE userId = :userId";
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
		String selectQuery = "FROM Address WHERE userId = :userId AND permanentAddress = :permanentAddress";
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
		String selectQuery = "FROM Address WHERE userId = :userId AND currentAddress = :currentAddress";
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

	@Override
	public List<Education> getEducationList() {
		try {
			return sessionFactory.getCurrentSession()
			.createQuery("FROM Education",Education.class)
			.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Education getEducationById(int educationId) {
		try {
			return sessionFactory.getCurrentSession().get(Education.class, Integer.valueOf(educationId));
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Education getEducationByUserId(int userId) {
		String selectQuery = "FROM Education WHERE userId = :userId";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery,Education.class)
					.setParameter("userId", userId)
					.getSingleResult();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addEducation(Education education) {
		try {
			sessionFactory.getCurrentSession().persist(education);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateEducation(Education education) {
		try {
			sessionFactory.getCurrentSession().update(education);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteEducation(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Company> getCompanyList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company getCompanyById(int companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company getCompanyByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCompany(Company company) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCompany(Company company) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCompany(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Experience> getExperienceList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Experience getExperienceById(int experienceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Experience getExperienceByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addExperience(Experience experience) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateExperience(Experience experience) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteExperience(int userId) {
		// TODO Auto-generated method stub
		return false;
	}


	}
