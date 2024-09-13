package flightpack;

import java.time.LocalDateTime;

public class Flight {

	private Airport origin;
	private Airport destination;
	private LocalDateTime flightDate;
	private int passengers;
	private int seats;
	private int distance;
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
