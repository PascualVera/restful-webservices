package com.rest.webservice.restfulwebservice;

import java.time.LocalDate;

public class ErrorDetails {
	 private LocalDate timestamp;
	 private String name;
	 private String details;
	public ErrorDetails(LocalDate timestamp, String name, String details) {
		super();
		this.timestamp = timestamp;
		this.name = name;
		this.details = details;
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public String getName() {
		return name;
	}
	public String getDetails() {
		return details;
	}
	 
}
