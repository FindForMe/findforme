package com.ffm_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
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
	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
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

	/*
	 * Address details
	 */
	
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
			//ex.printStackTrace();
			logger.error("current address is not found");
			return null;
		}
	}

	/*
	 * Education 
	 */
	@Override
	public List<Education> getEducationList(int userId) {
		String selectQuery = "FROM Education WHERE userId = :userId";
		try {
			return sessionFactory.getCurrentSession()
			.createQuery(selectQuery,Education.class)
			.setParameter("userId", userId)
			.getResultList();
		}catch(Exception ex) {
			logger.error("Education list not found");
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
	public boolean deleteEducation(int	userId) {
		Education education = new Education();
		education.setUserId(userId);
		try {
			sessionFactory.getCurrentSession().delete(education);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/*
	 * Company details
	 */
	
	@Override
	public List<Company> getCompanyList(int userId) {
		String selectQuery = "FROM Company WHERE userId = :userId";
		try {
			return sessionFactory.getCurrentSession()
			.createQuery(selectQuery,Company.class)
			.setParameter("userId", userId)
			.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Company getCompanyById(int companyId) {
		try {
			return sessionFactory.getCurrentSession().get(Company.class, Integer.valueOf(companyId));
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Company loadCompanyById(int companyId) {
		try {
			return sessionFactory.getCurrentSession().load(Company.class, Integer.valueOf(companyId));
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addCompany(Company company) {
		try {
			sessionFactory.getCurrentSession().persist(company);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCompany(Company company) {
		try {
			sessionFactory.getCurrentSession().update(company);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCompany(int userId) {

		String deleteQuery = "DELETE FROM Company WHERE userId =:userId";
		try {
			sessionFactory.getCurrentSession()
			.createQuery(deleteQuery)
			.setParameter("userId", userId)
			.executeUpdate();
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/*
	 * Experience details
	 */
	
	@Override
	public List<Experience> getExperienceList(int userId) {
		String selectQuery = "FROM Experience WHERE userId = :userId";
		try {
			return sessionFactory.getCurrentSession()
			.createQuery(selectQuery,Experience.class)
			.setParameter("userId", userId)
			.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Experience getExperienceById(int experienceId) {
		try {
			return sessionFactory.getCurrentSession().get(Experience.class, Integer.valueOf(experienceId));
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/*@Override
	public Experience getExperienceByUserId(int userId) {
		String selectQuery = "FROM Experience WHERE userId = :userId";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery,Experience.class)
					.setParameter("userId", userId)
					.getSingleResult();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}*/

	@Override
	public boolean addExperience(Experience experience) {
		try {
			sessionFactory.getCurrentSession().persist(experience);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateExperience(Experience experience) {
		try {
			sessionFactory.getCurrentSession().update(experience);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteExperience(int	userId) {
		Experience experience = new Experience();
		experience.setUserId(userId);
		try {
			sessionFactory.getCurrentSession().delete(experience);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	}
