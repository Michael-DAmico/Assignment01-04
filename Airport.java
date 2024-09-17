/**
 * @author Christian Burke and Michael D'Amico
 * @version 16 September 2024
 */
package flightpack;

/**
 * The {@code Airport} class represents an airport with its associated name, city, and state.
 * This class provides methods to retrieve and modify airport details.
 * It is used to represent the origin and destination airports in flight data.
 */
public class Airport {
	
	 private String name;
	 private String city;
	 private String state;
	 
	/**
	 * Constructs a new {@code Airport} with the specified name, city, and state.
	 * 
	 * @param name the name of the airport
	 * @param city the city where the airport is located
	 * @param state the state where the airport is located
	 */
	public Airport(String name, String city, String state) {
		 setName(name);
		 setCity(city);
		 setState(state);
		 
	 }
	

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * 
	 * @return state
	 */
	public String getState() {
		return state;
	}
	/**
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}
	
}
