package com.ffm_backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String addressLineOne;
	private String addressLineTwo;
	private String city;
	
	@Column(name = "postal_code")
	private String postalCode;
	private String state;
	private String country;
	@Column(name = "is_permanent")
	private boolean permanentAddress;
	
	@Column(name = "is_present")
	private boolean presentAddress;
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
	public boolean isPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(boolean presentAddress) {
		this.presentAddress = presentAddress;
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
				+ ", permanentAddress=" + permanentAddress + ", presentAddress=" + presentAddress + ", userId=" + userId
				+ "]";
	}
	
	

	
	
}
