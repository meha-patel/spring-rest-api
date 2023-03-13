package com.mehapatel.springRestAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@ToString
public class Employee {

	//	@JsonProperty("full_name")
	private String name;

//	@JsonIgnore
	private Long age;

	private String location;

	private String email;

	private String department;
	
}
