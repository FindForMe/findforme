package com.ffm_backend.dao;

public class Category {

	private int id;
	private String name;
	private String description;
	private String imgageUrl;
	private boolean active = true;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgageUrl() {
		return imgageUrl;
	}
	public void setImgageUrl(String imgageUrl) {
		this.imgageUrl = imgageUrl;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
		
	
}
