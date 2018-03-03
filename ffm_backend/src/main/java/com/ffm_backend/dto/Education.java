package com.ffm_backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "education_details")
public class Education implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String graduation;
	
	@Column(name = "graduation_other")
	private String graducationOther;
	@Column(name = "graduation_year")
	private int gradutaionYear;
	@Column(name="graduation_percentage")
	private double graduationPercentage;
	
	private String intermediate;
	@Column(name="intermediate_year")
	int intermediateYear;
	@Column(name="intermediate_percentage")
	private double intermediatePercentage;
	
	private String highSchool;
	@Column(name="highschool_year")
	private int highSchoolYear;
	@Column(name="highSchool_percentage")
	private double highSchoolPercentage;
	
	/*private String experience;
	@Column(name = "experience_duration")
	private String experienceTime;*/
	
	@Column(name = "userid")
	private int userId;
	
	public String getGraducationOther() {
		return graducationOther;
	}
	public void setGraducationOther(String graducationOther) {
		this.graducationOther = graducationOther;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGraduation() {
		return graduation;
	}
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
	public int getGradutaionYear() {
		return gradutaionYear;
	}
	public void setGradutaionYear(int gradutaionYear) {
		this.gradutaionYear = gradutaionYear;
	}
	public double getGraduationPercentage() {
		return graduationPercentage;
	}
	public void setGraduationPercentage(double graduationPercentage) {
		this.graduationPercentage = graduationPercentage;
	}
	public String getIntermediate() {
		return intermediate;
	}
	public void setIntermediate(String intermediate) {
		this.intermediate = intermediate;
	}
	public int getIntermediateYear() {
		return intermediateYear;
	}
	public void setIntermediateYear(int intermediateYear) {
		this.intermediateYear = intermediateYear;
	}
	public double getIntermediatePercentage() {
		return intermediatePercentage;
	}
	public void setIntermediatePercentage(double intermediatePercentage) {
		this.intermediatePercentage = intermediatePercentage;
	}
	public String getHighSchool() {
		return highSchool;
	}
	public void setHighSchool(String highSchool) {
		this.highSchool = highSchool;
	}
	public int getHighSchoolYear() {
		return highSchoolYear;
	}
	public void setHighSchoolYear(int highSchoolYear) {
		this.highSchoolYear = highSchoolYear;
	}
	public double getHighSchoolPercentage() {
		return highSchoolPercentage;
	}
	public void setHighSchoolPercentage(double highSchoolPercentage) {
		this.highSchoolPercentage = highSchoolPercentage;
	}
	
	
		
	
	
	
	
}
