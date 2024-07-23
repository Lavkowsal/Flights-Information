package com.flightInformation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightInformation.model.FlightInformationEntityDto;

/**
 * The Interface FlightInfoRepository.
 */
public interface FlightInfoRepository extends JpaRepository<FlightInformationEntityDto, Long> {

}
