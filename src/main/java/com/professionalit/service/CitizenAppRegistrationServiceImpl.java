package com.professionalit.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.professionalit.domain.CitizenAppRegistrationRequest;
import com.professionalit.entity.CitizenAppRegistrationEntity;
import com.professionalit.repository.CitizenApplicationRegistrationRepository;
import com.professionalit.util.ValidationUtil;

@Service
public class CitizenAppRegistrationServiceImpl implements CitizenAppRegistrationService {

	CitizenAppRegistrationEntity citizenAppRegistrationEntity=new CitizenAppRegistrationEntity();
//	@Autowired
//	private RestTemplate template;
	@Value("${ar.ssn-web}")
	private String endPointUrl;
	
	@Value("${ar.state}")
	private String state;
	@Autowired
	private WebClient webClient;
	@Autowired
	private ValidationUtil validateUtil;
	
	@Autowired
	CitizenApplicationRegistrationRepository citizenApplicationRegistrationRepository;
	/*
	 * @Override public long registeCitizenApplication(CitizenAppRegistrationRequest
	 * citizenAppRegistrationRequest) { // TODO Auto-generated method stub
	 * 
	 * ResponseEntity<String>
	 * response=template.exchange("http://localhost:8000/ssn-web-api/find/{ssn}",
	 * HttpMethod.GET,null,String.class,citizenAppRegistrationRequest.getSsn());
	 * String stateName=response.getBody(); if("Texas".equals(stateName))
	 * 
	 * BeanUtils.copyProperties(citizenAppRegistrationRequest,
	 * citizenAppRegistrationEntity);
	 * citizenAppRegistrationEntity.setCreatedBy("suraj");
	 * citizenAppRegistrationEntity.setUpdatedBy("suraj");
	 * CitizenAppRegistrationEntity
	 * citizenAppRegistrationResponse=citizenApplicationRegistrationRepository.save(
	 * citizenAppRegistrationEntity); long
	 * appId=citizenAppRegistrationResponse.getApplicationId(); return appId;
	 * 
	 * 
	 * }
	 */
	@Override
	public long registeCitizenApplication(CitizenAppRegistrationRequest citizenAppRegistrationRequest) {
//	    String url = "http://localhost:8000/ssn-web-api/find/{ssn}";
//
//	    // Call external service to get state name
//	    ResponseEntity<String> response = template.exchange(
//	        url,
//	        HttpMethod.GET,
//	        null,
//	        String.class,
//	        citizenAppRegistrationRequest.getSsn()
//	    );
		
		//call exception
	validateUtil.validateCitizen(citizenAppRegistrationRequest);

		String stateName = webClient.get()
	            .uri(endPointUrl,citizenAppRegistrationRequest.getSsn())
	            .retrieve()
	            .bodyToMono(String.class)
	            .block();
//	    String stateName = response.getBody();
	    if (state.equalsIgnoreCase(stateName)) {
	        // Create a new instance of the entity for each request
	        CitizenAppRegistrationEntity citizenAppRegistrationEntity = new CitizenAppRegistrationEntity();
	        BeanUtils.copyProperties(citizenAppRegistrationRequest, citizenAppRegistrationEntity);
	        citizenAppRegistrationEntity.setCreatedBy("suraj");
	        citizenAppRegistrationEntity.setUpdatedBy("suraj");
	        citizenAppRegistrationEntity.setStateName(stateName);

	        // Save to the database
	        CitizenAppRegistrationEntity savedEntity = citizenApplicationRegistrationRepository.save(citizenAppRegistrationEntity);
	        return savedEntity.getApplicationId();
	    }
	    return 0; // Return 0 for unsuccessful registration
	}


}
