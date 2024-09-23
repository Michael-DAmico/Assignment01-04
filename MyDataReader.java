/**
 * @author Christian Burke and Michael D'Amico
 * @version 16 September 2024
 */
package flightpack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * The {@code MyDataReader} class provides methods to read and process flight data from a CSV file.
 * It includes utilities to convert string data into {@code LocalDateTime} objects and methods 
 * to convert lines from the file into {@code Flight} objects.
 */
public class MyDataReader {
	// DateTime formatter for parsing date strings in the format "yyyy-MM-dd:HH"
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH");
	/**
     * Converts a string representing a date and time into a {@code LocalDateTime} object.
     *
     * @param dateTimeString the string representation of the date and time
     * @return the corresponding {@code LocalDateTime} object
     */
	public static LocalDateTime dateConvert(String dateTimeString) {
		return LocalDateTime.parse(dateTimeString, formatter);
	}
	
	/**
     * Converts a line of CSV data into a {@code Flight} object.
     * 
     * The line is expected to contain the following information, in this order:
     * origin airport name, origin city, origin state, destination airport name, 
     * destination city, destination state, number of passengers, number of seats, 
     * flight distance, and flight date in the format "yyyy-MM-dd:HH".
     *
     * @param inputLine a line of CSV data representing a flight record
     * @return a {@code Flight} object created from the input line
     */
	private static Flight lineToReport(String inputLine) {
		String[]items = inputLine.split(",");
		
		String originName  = items[0];
		String originCity  = items[1];
		String originState = items[2];
		
		Airport origin = new Airport(originName, originCity, originState);
		Airport destination = new Airport(items[3], items[4], items[5]);

		int passengers = Integer.parseInt(items[6]);
		int seats = Integer.parseInt(items[7]);
		int distance = Integer.parseInt(items[8]);
		LocalDateTime flightDate = dateConvert(items[9]);
		
		return new Flight(origin, destination, flightDate, passengers, seats, distance);
		
	}
	
	/**
     * Reads a CSV file containing flight data and returns an array of {@code Flight} objects.
     * 
     * Each line in the file is converted into a {@code Flight} object using the 
     * {@code lineToReport} method. The method skips the first line, which is assumed 
     * to be the header. The array has a fixed size of 3,000,000 entries.
     *
     * @param filePath the path to the CSV file containing flight data
     * @return an array of {@code Flight} objects read from the file
     */
	/**public static Flight[] readDataFile(String filePath) {
		
		Flight[] data = new Flight[3000000];
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			
			String str;
			br.readLine();
			
			int currentIndex = 0;
			
			while ((str = br.readLine()) != null) {
				data[currentIndex] = lineToReport(str);
			    currentIndex++;
			}
		}
		
		catch (IOException e) {
			System.out.println("Error while reading a file.");
		}
		
		return data;
	}
*/
	// Modified the readDataFile method in MyDataReader so that instead of returning an array of flights, 
	// it adds the flights to a MyArrayList object.
	
	public static MyArrayList<Flight> readDataFile(String filePath, String state) {
	    MyArrayList<Flight> flights = new MyArrayList<>();

	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	        String str;
	        br.readLine(); // skip header

	        while ((str = br.readLine()) != null) {
	            Flight flight = lineToReport(str);
	            if (flight.getOrigin().getState().equalsIgnoreCase(state)) {
	                flights.add(flight);
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("Error while reading the file.");
	    }

	    return flights;
	}
}
