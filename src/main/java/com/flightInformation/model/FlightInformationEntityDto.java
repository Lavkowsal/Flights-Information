package com.flightInformation.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FlightInformationEntityDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The flight date. */
	public String flightDate;

	/** The flight status. */
	public String flightStatus;

	/** The airport. */
	public String airport;

	/** The scheduled. */
	public Date depatureScheduled;

	/** The scheduled. */
	public Date arrivalScheduled;
	

}
