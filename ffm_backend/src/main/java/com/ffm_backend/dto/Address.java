package com.ffm_backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "address")
public class Address implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/*private String addressLineOne;
	private String addressLineTwo;
	private String city;*/
	
	
	@NotBlank(message = "Please enter address line one!")
	@Column(name = "address_line_one")
	private String addressLineOne;
	@NotBlank(message = "Please enter address line two!")	
	@Column(name = "address_line_two")
	private String addressLineTwo;
	@NotBlank(message = "Please enter City!")	
	private String city;
	@NotBlank(message = "Please enter State!")	
	private String state;
	@NotBlank(message = "Please enter country!")	
	private String country;
	@Column(name ="postal_code")
	@NotBlank(message = "Please enter Postal Code!")	
	private String postalCode;
	
	/*
	@Column(name = "postal_code")
	private String postalCode;
	private String state;
	private String country;*/
	@Column(name = "is_permanent")
	private boolean permanentAddress;
	
	@Column(name = "is_current")
	private boolean currentAddress;
	@Column(name = "userid")
	private int userId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean isPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(boolean permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public boolean isCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(boolean currentAddress) {
		this.currentAddress = currentAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo
				+ ", city=" + city + ", postalCode=" + postalCode + ", state=" + state + ", country=" + country
				+ ", permanentAddress=" + permanentAddress + ", currentAddress=" + currentAddress + ", userId=" + userId
				+ "]";
	}
	
}
