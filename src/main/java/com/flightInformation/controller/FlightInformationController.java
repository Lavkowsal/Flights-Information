
package com.flightInformation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightInformation.model.FlightInformationEntityDto;
import com.flightInformation.service.FlightInfoServiceUtils;
import com.flightInformation.service.FlightInformationService;

import jakarta.servlet.http.HttpServletResponse;

/**
 * The Class FlightInformationController.
 */
@RestController
@RequestMapping("/api/flightInfo")
public class FlightInformationController {

	/** The flight info service. */

	private FlightInfoServiceUtils flightInfoService;

	/** The flight information service. */

	private FlightInformationService flightInformationService;

	public FlightInformationController(FlightInfoServiceUtils flightInfoService,
			FlightInformationService flightInformationService) {
		this.flightInfoService = flightInfoService;
		this.flightInformationService = flightInformationService;
	}

	/**
	 * Gets the flights information.
	 *
	 * @return the flights information
	 */
	@GetMapping("/getFlights")
	public FlightInformationEntityDto getFlightsInformation() {
		return flightInformationService.getFlights();
	}

	/**
	 * Export flight information.
	 *
	 * @param format   the format
	 * @param response the response
	 */
	@GetMapping("/downloads")
	public void exportFlightInformation(@RequestParam String format, HttpServletResponse response) {
		flightInfoService.downloadFlightDetails(format, response);
	}
}
