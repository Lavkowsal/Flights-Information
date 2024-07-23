package com.flightInformation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flightInformation.model.FlightInformationEntityDto;
import com.flightInformation.model.FlightResponeDTO;
import com.flightInformation.model.FlightResponeDTO.Data;
import com.flightInformation.repository.FlightInfoRepository;

/**
 * The Class FlightInformationService.
 */
@Service
public class FlightInformationService {

	@Value("${mocki.io.dummy.data}")
	private String dummyUrl;

	/** The rest template. */
	@Autowired
	private final RestTemplate restTemplate;

	/** The flight info repository. */
	@Autowired
	private FlightInfoRepository flightInfoRepository;

	/**
	 * Instantiates a new flight information service.
	 *
	 * @param restTemplate         the rest template
	 * @param flightInfoRepository the flight info repository
	 */
	public FlightInformationService(RestTemplate restTemplate, FlightInfoRepository flightInfoRepository) {
		this.restTemplate = restTemplate;
		this.flightInfoRepository = flightInfoRepository;
	}

	/**
	 * Gets the flights.
	 *
	 * @return the flights
	 */
	public FlightInformationEntityDto getFlights() {

		FlightInformationEntityDto result = null;

		FlightResponeDTO response = restTemplate
				.getForObject("https://mocki.io/v1/c9fe44cf-b082-4a1a-a4bc-10d7ff13d466", FlightResponeDTO.class);
		for (Data data : response.getData()) {
			FlightInformationEntityDto entityDto = new FlightInformationEntityDto();
			entityDto.setFlightDate(data.flight_date);
			entityDto.setArrivalScheduled(data.arrival.scheduled);
			entityDto.setDepatureScheduled(data.departure.scheduled);
			entityDto.setFlightStatus(data.flight_status);
			entityDto.setAirport(data.departure.airport);
			result = flightInfoRepository.save(entityDto);

		}

		return result;
	}
}
