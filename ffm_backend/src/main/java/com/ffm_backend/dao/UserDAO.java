package com.ffm_backend.dao;

import java.util.List;

import com.ffm_backend.dto.Address;
import com.ffm_backend.dto.Company;
import com.ffm_backend.dto.Education;
import com.ffm_backend.dto.Experience;
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
	
	
	//adding and updating education 
	List<Education> getEducationList();
	Education getEducationById(int educationId);
	Education getEducationByUserId(int userId);
	boolean addEducation(Education education);
	boolean updateEducation(Education eduacation);
	boolean deleteEducation(int userId);
	
	//adding and updating company 
	List<Company> getCompanyList();
	Company getCompanyById(int companyId);
	Company getCompanyByUserId(int userId);
	boolean addCompany(Company company);
	boolean updateCompany(Company company);
	boolean deleteCompany(int userId);
	
	//adding and updating experience 
	List<Experience> getExperienceList();
	Experience getExperienceById(int experienceId);
	Experience getExperienceByUserId(int userId);
	boolean addExperience(Experience experience);
	boolean updateExperience(Experience experience);
	boolean deleteExperience(int userId);
	
}
