package com.rest.webservice.restfulwebservice.user;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	
	private Integer id;
	@Size(min=6)
	private String name;
	@Past
	private LocalDate bDay;
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
