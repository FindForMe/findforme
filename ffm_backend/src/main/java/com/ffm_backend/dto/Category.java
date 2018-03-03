package com.ffm_backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "category")
public class Category implements  Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	private String name;
	private String description;
	
	@Column(name = "image_url")
	private String imgURL;
	
	//@Type(type= "org.hibernate.type.NumericBooleanType")
	//@org.hibernate.annotations.Type(type="true_false")
	@Type(type="boolean")
	@Column(name = "active", columnDefinition = "char(1) not null")
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
	
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active ) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", imgURL=" + imgURL
				+ ", active=" + active + "]";
	}
	
	
}
