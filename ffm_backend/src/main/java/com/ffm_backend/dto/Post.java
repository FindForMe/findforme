package com.ffm_backend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ffm_backend.util.ffmUtil;

@Entity(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	//private String shortDescription;//todo later
	private String description;
	
	@Column(name = "user_id")
	@JsonIgnore
	private int userId;
	
	@Column(name = "category_id")
	@JsonIgnore
	private int categoryId;
	
	@Column(name = "image_url")
	private String imgURl;
	private boolean active = true;
	@JsonIgnore
	private String created = ffmUtil.genCurrDateTime();
	@JsonIgnore
	private String modified;
	@JsonIgnore
	private String rowId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescriptioin() {
		return description;
	}

	public void setDescriptioin(String descriptioin) {
		this.description = descriptioin;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getImgURl() {
		return imgURl;
	}

	public void setImgURl(String imgURl) {
		this.imgURl = imgURl;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
}
