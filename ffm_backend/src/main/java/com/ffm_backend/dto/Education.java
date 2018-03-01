package com.ffm_backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "education_details")
public class Education implements Serializable {
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
	

}
