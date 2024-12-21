package com.professionalit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.professionalit.entity.CitizenAppRegistrationEntity;

public interface CitizenApplicationRegistrationRepository extends JpaRepository<CitizenAppRegistrationEntity,Long> {

}
