package com.professionalit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.professionalit.domain.CitizenAppRegistrationRequest;
import com.professionalit.service.CitizenAppRegistrationService;
import com.professionalit.service.CitizenAppRegistrationServiceImpl;

@RestController
public class CitizenApplicationRegistrationController {
	@Autowired 
	CitizenAppRegistrationService citizenApplicationService;
	@Autowired
	CitizenAppRegistrationServiceImpl citizenAppRegistrationServiceImpl;
	
	@PostMapping("/Register-Citizen-info")
	public ResponseEntity<String>saveCitizenApplication(@RequestBody CitizenAppRegistrationRequest citizenAppRegistrationRequest){
		long applicationId=citizenApplicationService.registeCitizenApplication(citizenAppRegistrationRequest);
		if(applicationId>0) {
			
			return new ResponseEntity<String>("citizen Aplication REGISTERD SuccesFully",HttpStatus.BAD_REQUEST);
		}else
		{
		return new ResponseEntity<String>("Application Not Registerd ",HttpStatus.CREATED);
	}
		}
}
