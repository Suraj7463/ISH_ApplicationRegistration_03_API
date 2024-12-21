package com.professionalit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name="ISHRegistration_Table")
public class CitizenAppRegistrationEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Applicateion_Id")
	private Long applicationId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column(length=1)
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
	
	@CreationTimestamp
	@Column(updatable=false,nullable=false)
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(nullable=false)
	private LocalDate updatedDate;
	
	@Column(updatable=false,nullable=false)
	private String createdBy;
	
	@Column(nullable=false)
	private String updatedBy;

	

}
