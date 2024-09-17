/**
 * @author Christian Burke and Michael D'Amico
 * @version 16 September 2024
 */
package flightpack;
import java.util.HashSet;
import java.util.Set;


/**
 * The {@code MyAnalyzer} class provides methods to analyze and extract 
 * information from flight data. It includes tasks to get information such as 
 * unique airports in Maine, maximum passengers to a specific airport, percentage 
 * of full flights, and average passengers for specific flight routes and years.
 */
public class MyAnalyzer {
	
	/**
	 * Task 4.a
	 * Retrieves a set of unique airport names in the state of Maine.
     * This method checks both the origin and destination airports of each flight 
     * and returns those located in Maine. 
     * 
	 * @param flights an array of {@code Flight} objects representing the flight data
	 * @return a set of airport names in Maine
	 */ 
    public static Set<String> getAirportsInMaine(Flight[] flights) {
        Set<String> maineAirports = new HashSet<>();

        for (Flight flight : flights) {
            if (flight != null) {
                // Check origin airport
                if (flight.getOrigin().getState().equalsIgnoreCase("ME")) {
                    maineAirports.add(flight.getOrigin().getName());
                }
                // Check destination airport
                if (flight.getDestination().getState().equalsIgnoreCase("ME")) {
                    maineAirports.add(flight.getDestination().getName());
                }
            }
        }
        return maineAirports;
    }
    
    
    /**
     * Task 4.b
     * 
     * Finds the maximum number of passengers on flights arriving at Portland International Jetport (PWM).
     * 
     * @param flights an array of {@code Flight} objects representing the flight data
     * @return the maximum number of passengers on a flight to PWM (Portland, Maine)
     */
    public static int getMaxPassengersToPWM(Flight[] flights) {
        int maxPassengers = 0;

        for (Flight flight : flights) {
            if (flight != null && flight.getDestination().getName().equalsIgnoreCase("PWM") && flight.getDestination().getCity().equalsIgnoreCase("Portland")) {
                maxPassengers = Math.max(maxPassengers, flight.getPassengers());
            }
        }
        return maxPassengers;
    }

    /**
     * Task 4.c
     * Calculates the percentage of flights that are fully booked (i.e., have no empty seats).
     * 
     * @param flights an array of {@code Flight} objects representing the flight data
     * @return the percentage of full flights as a double
     */
       public static double getPercentageOfFullFlights(Flight[] flights) {
           int fullFlights = 0;
           int totalFlights = 0;

           for (Flight flight : flights) {
               if (flight != null) {
                   totalFlights++;
                   if (flight.getPassengers() == flight.getSeats()) {
                       fullFlights++;
                   }
               }
           }

           if (totalFlights == 0) {
               return 0; // Avoid division by zero
           }

           return (fullFlights * 100.0) / totalFlights;
       }
       
       
       /**
        * Task 4.d
        * Calculates the average number of passengers on flights from a specific airport to a specific state in a given year.
        * 
        * @param flights an array of {@code Flight} objects representing the flight data
        * @param airport the origin airport code (e.g., "PWM" for Portland, Maine)
        * @param state the destination state abbreviation (e.g., "FL" for Florida)
        * @param year the year of the flights (e.g., 2009)
        * @return the average number of passengers on flights from the given airport to the specified state in the given year
        */
       public static double getAveragePassengersFromAirportToStateInYear(Flight[] flights, String airport, String state, int year) {
           int totalPassengers = 0;
           int flightCount = 0;

           for (Flight flight : flights) {
               if (flight != null &&
                   flight.getOrigin().getName().equalsIgnoreCase(airport) &&
                   flight.getDestination().getState().equalsIgnoreCase(state) &&
                   flight.getFlightDate().getYear() == year) {

                   totalPassengers += flight.getPassengers();
                   flightCount++;
               }
           }

           if (flightCount == 0) {
               return 0; // Avoid division by zero
           }

           return (double) totalPassengers / flightCount;
       }
}
