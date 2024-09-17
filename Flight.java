/**
 * @author Christian Burke and Michael D'Amico
 * @version 16 September 2024
 */
package flightpack;

import java.time.LocalDateTime;



/**
 * The {@code Flight} class represents a flight record, including details such as 
 * the origin and destination airports, flight date, number of passengers, seats, 
 * and distance traveled.
 * 
 * This class provides getter and setter methods to access and modify the flight information.
 */
public class Flight {

	private Airport origin;
	private Airport destination;
	private LocalDateTime flightDate;
	private int passengers;
	private int seats;
	private int distance;
	
	 /**
     * Constructs a new {@code Flight} with the specified origin and destination airports,
     * flight date, number of passengers, available seats, and distance traveled.
     * 
     * @param origin the origin {@code Airport} of the flight
     * @param destination the destination {@code Airport} of the flight
     * @param flightDate the date and time of the flight
     * @param passengers the number of passengers on the flight
     * @param seats the total number of seats available on the flight
     * @param distance the distance traveled by the flight in miles
     */
	public Flight(Airport origin, Airport destination, LocalDateTime flightDate, int passengers, int seats, int distance) {
		this.origin=origin;
		this.destination=destination;
		this.flightDate=flightDate;
		this.passengers=passengers;
		this.seats=seats;
		this.distance=distance;
	}
	
	/**
	 * @return the origin
	 */
	public Airport getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 *
	 */
	public void setOrigin(Airport origin) {
		this.origin = origin;
	}

	/**
	 * @return the destination
	 */
	public Airport getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	/**
	 * @return the flightDate
	 */
	public LocalDateTime getFlightDate() {
		return flightDate;
	}

	/**
	 * @param flightDate the flightDate to set
	 */
	public void setFlightDate(LocalDateTime flightDate) {
		this.flightDate = flightDate;
	}

	/**
	 * @return the passengers
	 */
	public int getPassengers() {
		return passengers;
	}

	/**
	 * @param passengers the passengers to set
	 */
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	/**
	 * @return the seats
	 */
	public int getSeats() {
		return seats;
	}

	/**
	 * @param seats the seats to set
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}

	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
}
