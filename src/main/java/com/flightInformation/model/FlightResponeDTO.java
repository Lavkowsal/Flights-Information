package com.flightInformation.model;

import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class FlightResponeDTO.
 */
@Getter
@Setter
public class FlightResponeDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The pagination. */
	public Pagination pagination;

	/** The data. */
	public ArrayList<Data> data;

	/**
	 * The Class Pagination.
	 */
	public static class Pagination {

		/** The limit. */
		public int limit;

		/** The offset. */
		public int offset;

		/** The count. */
		public int count;

		/** The total. */
		public int total;
	}

	/**
	 * The Class Data.
	 */
	public static class Data {

		/** The flight date. */
		public String flight_date;

		/** The flight status. */
		public String flight_status;

		/** The departure. */
		public Departure departure;

		/** The arrival. */
		public Arrival arrival;

		/** The airline. */
		public Airline airline;

		/** The flight. */
		public Flight flight;

		/** The aircraft. */
		public Aircraft aircraft;

		/** The live. */
		public Live live;

	}

	/**
	 * The Class Departure.
	 */
	public static class Departure {

		/** The airport. */
		public String airport;

		/** The timezone. */
		public String timezone;

		/** The iata. */
		public String iata;

		/** The icao. */
		public String icao;

		/** The terminal. */
		public String terminal;

		/** The gate. */
		public String gate;

		/** The delay. */
		public int delay;

		/** The scheduled. */
		public Date scheduled;

		/** The estimated. */
		public Date estimated;

		/** The actual. */
		public Date actual;

		/** The estimated runway. */
		public Date estimated_runway;

		/** The actual runway. */
		public Date actual_runway;
	}

	/**
	 * The Class Flight.
	 */
	public static class Flight {

		/** The number. */
		public String number;

		/** The iata. */
		public String iata;

		/** The icao. */
		public String icao;

		/** The codeshared. */
		public Object codeshared;
	}

	/**
	 * The Class Live.
	 */
	public static class Live {

		/** The updated. */
		public Date updated;

		/** The latitude. */
		public double latitude;

		/** The longitude. */
		public double longitude;

		/** The altitude. */
		public double altitude;

		/** The direction. */
		public double direction;

		/** The speed horizontal. */
		public double speed_horizontal;

		/** The speed vertical. */
		public double speed_vertical;

		/** The is ground. */
		public boolean is_ground;
	}

	/**
	 * The Class Airline.
	 */
	public static class Airline {

		/** The name. */
		public String name;

		/** The iata. */
		public String iata;

		/** The icao. */
		public String icao;
	}

	/**
	 * The Class Arrival.
	 */
	public static class Arrival {

		/** The airport. */
		public String airport;

		/** The timezone. */
		public String timezone;

		/** The iata. */
		public String iata;

		/** The icao. */
		public String icao;

		/** The terminal. */
		public String terminal;

		/** The gate. */
		public String gate;

		/** The baggage. */
		public String baggage;

		/** The delay. */
		public int delay;

		/** The scheduled. */
		public Date scheduled;

		/** The estimated. */
		public Date estimated;

		/** The actual. */
		public Object actual;

		/** The estimated runway. */
		public Object estimated_runway;

		/** The actual runway. */
		public Object actual_runway;
	}

	/**
	 * The Class Aircraft.
	 */
	public static class Aircraft {

		/** The registration. */
		public String registration;

		/** The iata. */
		public String iata;

		/** The icao. */
		public String icao;

		/** The icao 24. */
		public String icao24;
	}
}
