package com.v2tech.surveysystem.domain;

import javax.persistence.Entity;

@Entity
public class User extends Base{
	
	private String email;
	
	private String name;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
