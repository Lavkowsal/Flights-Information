package com.flightInformation.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.flightInformation.model.FlightInformationEntityDto;
import com.flightInformation.repository.FlightInfoRepository;
import com.opencsv.CSVWriter;

import jakarta.servlet.http.HttpServletResponse;

/**
 * The Class FlightInfoServiceUtils.
 */
@Service
public class FlightInfoServiceUtils {

	/** The flight info repository. */
	private FlightInfoRepository flightInfoRepository;

	/**
	 * Instantiates a new flight info service utils.
	 *
	 * @param flightInfoRepository the flight info repository
	 */
	public FlightInfoServiceUtils(FlightInfoRepository flightInfoRepository) {

		this.flightInfoRepository = flightInfoRepository;
	}

	/**
	 * Download flight details.
	 *
	 * @param format   the format
	 * @param response the response
	 */
	public void downloadFlightDetails(String format, HttpServletResponse response) {
		List<FlightInformationEntityDto> flightInfo = flightInfoRepository.findAll();

		switch (format.toLowerCase()) {

		case "json":
			exportToJson(flightInfo, response);
			break;
		case "csv":
			exportToCsv(flightInfo, response);
			break;
		default:
			handleUnsupportedFormat(format, response);
		}

	}

	/**
	 * Export to json.
	 *
	 * @param flightInfo the flight info
	 * @param response   the response
	 */
	public void exportToJson(List<FlightInformationEntityDto> flightInfo, HttpServletResponse response) {
		// Set the content type to JSON for the response
		response.setContentType("application/json");

		// Set the header to indicate a file attachment with a specific filename
		response.setHeader("Content-Disposition", "attachment; filename=flightInfo.json");

		try {
			// Create a new ObjectMapper instance to handle JSON conversion
			ObjectMapper objectMapper = new ObjectMapper();

			// Register the JavaTimeModule to handle Java 8 date/time types
			objectMapper.registerModule(new JavaTimeModule());

			// Convert the list of FlightInformationEntityDto to a formatted JSON string
			String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(flightInfo);

			// Write the JSON string to the response's output stream
			response.getWriter().write(json);
		} catch (IOException e) {
			// Handle any IOExceptions that occur during the process
			throw new RuntimeException("Failed to write JSON", e);
		}

	}


	/**
	 * Export to csv.
	 *
	 * @param flightInfo the flight info
	 * @param response   the response
	 */
	private void exportToCsv(List<FlightInformationEntityDto> flightInfo, HttpServletResponse response) {
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=flightInfo.csv");

		try (CSVWriter writer = new CSVWriter(response.getWriter())) {
			String[] header = { "FlightDate", "Flight Status", "Airport", "Departure", "Arrival" };
			writer.writeNext(header);

			for (FlightInformationEntityDto flightDetail : flightInfo) {
				writer.writeNext(new String[] { flightDetail.getAirport(), flightDetail.getFlightDate(),
						flightDetail.getFlightStatus(), flightDetail.getArrivalScheduled().toString(),
						flightDetail.getDepatureScheduled().toString() });
			}
		} catch (IOException e) {
			throw new RuntimeException("Failed to write CSV", e);
		}
	}

	/**
	 * Handle unsupported format.
	 *
	 * @param format   the format
	 * @param response the response
	 */
	private void handleUnsupportedFormat(String format, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		try (PrintWriter writer = response.getWriter()) {
			writer.write("Invalid format: " + format);
		} catch (IOException e) {
			throw new RuntimeException("Failed to write error response", e);
		}
	}

}
