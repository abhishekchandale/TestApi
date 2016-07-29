package com.example.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.response.SuperResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="blog_author")
public class UserDao extends SuperResponse{
	
	public UserDao(){
		//constructor
	}
	
public UserDao(Long id, String firstName, String lastName, String email,
			String dOB, String workDomain, String designation,
			String compnayName, String password, String mobile, String randomId) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.DOB = dOB;
		this.WorkDomain = workDomain;
		this.designation = designation;
		this.CompnayName = compnayName;
		this.password = password;
		this.mobile = mobile;
		this.randomId = randomId;
	}

@Id
    @GeneratedValue
    @JsonProperty
    @Column(name="id")
	private Long Id;
    @JsonProperty
    @Column(name="first_name")
    private String firstName;
    @JsonProperty
    @Column(name="last_name")
    private String lastName;
    @JsonProperty
    @Column(name="email")
    private String email;
    @JsonProperty
    @Column(name="dob")
    private String DOB;
    @JsonProperty
    @Column(name="work_domain")
    private String WorkDomain;
    @JsonProperty
    @Column(name="company_designation")
    private String designation;
    @JsonProperty
    @Column(name="company_name")
    private String CompnayName;
    @JsonProperty
    @Column(name="password")
    private String password;
    @JsonProperty
    @Column(name="mobile")
    private String mobile;
    @JsonProperty
    @Column(name="unique_id")
    private String randomId;
    
    
	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDOB() {
		return DOB;
	}


	public void setDOB(String dOB) {
		DOB = dOB;
	}


	public String getWorkDomain() {
		return WorkDomain;
	}


	public void setWorkDomain(String workDomain) {
		WorkDomain = workDomain;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getCompnayName() {
		return CompnayName;
	}


	public void setCompnayName(String compnayName) {
		CompnayName = compnayName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}





	public String getRandomId() {
		return randomId;
	}





	public void setRandomId(String randomId) {
		this.randomId = randomId;
	}
    
    



	

}
