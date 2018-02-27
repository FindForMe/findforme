package com.ffm.model;

import java.io.Serializable;

import com.ffm_backend.dto.Apply;

public class UserModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String fullName;
	private String role;
	private Apply apply;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Apply getApply() {
		return apply;
	}
	public void setApply(Apply apply) {
		this.apply = apply;
	}
	
		
}

