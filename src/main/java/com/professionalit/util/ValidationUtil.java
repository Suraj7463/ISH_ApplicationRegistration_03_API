package com.professionalit.util;

import org.springframework.stereotype.Component;

import com.professionalit.domain.CitizenAppRegistrationRequest;
import com.professionalit.exception.InvalidSSNException;

@Component
public class ValidationUtil {
	
	public void validateCitizen(CitizenAppRegistrationRequest citizenAppRegistrationRequest) {
		if(citizenAppRegistrationRequest.getSsn().length()!=9)
		{
			throw new InvalidSSNException("invalid ssn number please put valid ssn number");
		}
	}

}
