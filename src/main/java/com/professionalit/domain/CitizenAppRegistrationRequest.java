package com.professionalit.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CitizenAppRegistrationRequest {
	
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String gender;
	
	@Column
	private LocalDate dob;
	@Column
	private String email;
	@Column
	private String phoneNo;
	@Column
	private String ssn;
	@Column
	private String stateName;

}
