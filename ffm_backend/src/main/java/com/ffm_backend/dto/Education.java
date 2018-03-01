package com.ffm_backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "education_details")
public class Education implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="")
	private String graduation;
	@Column(name = "graduation_year")
	private int gradutaionYear;
	@Column(name="graduation_percentage")
	private int graduationPercentage;
	
	private String intermediate;
	@Column(name="intermediate_year")
	int intermediateYear;
	@Column(name="intermediate_percentage")
	private int intermediatePercentage;
	
	private String highSchool;
	@Column(name="highschool_year")
	private int highSchoolYear;
	@Column(name="highSchool_percentage")
	private int highSchoolPercentage;
	
	private String experience;
	@Column(name = "experience_duration")
	private String experienceTime;
	
	@Column(name = "userid")
	private int userId;

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

	public int getGraduationPercentage() {
		return graduationPercentage;
	}

	public void setGraduationPercentage(int graduationPercentage) {
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

	public int getIntermediatePercentage() {
		return intermediatePercentage;
	}

	public void setIntermediatePercentage(int intermediatePercentage) {
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

	public int getHighSchoolPercentage() {
		return highSchoolPercentage;
	}

	public void setHighSchoolPercentage(int highSchoolPercentage) {
		this.highSchoolPercentage = highSchoolPercentage;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getExperienceTime() {
		return experienceTime;
	}

	public void setExperienceTime(String experienceTime) {
		this.experienceTime = experienceTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
	
	
	
}
