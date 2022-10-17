package com.rest.webservice.restfulwebservice.user;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "user_details")
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=6)
	@JsonProperty("user_name")
	private String name;
	
	@Past
	@JsonProperty("b_day")
	private LocalDate bDay;
	protected User() {
		
	}
	
	public User(Integer id, String name, LocalDate bDay) {
		super();
		this.id = id;
		this.name = name;
		this.bDay = bDay;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getbDay() {
		return bDay;
	}
	public void setbDay(LocalDate bDay) {
		this.bDay = bDay;
	}
	
	
}
