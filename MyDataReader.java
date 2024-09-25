package flightpack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Utility class for reading flight data from a file and converting it into a list of Flight objects.
 * Provides methods for parsing dates and creating Flight instances from a line in the file.
 * 
 * @author Christian Burke and Michael D'Amico
 * @version 23 September 2024
 */
public class MyDataReader {

	/**
     * A formatter to convert date strings in the format "yyyy-MM-dd:HH" to {@link LocalDateTime}.
     */
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH");

    /**
     * Converts a date string into a {@link LocalDateTime} object based on the specified format.
     * 
     * @param dateTimeString A string representing the date and time in the format "yyyy-MM-dd:HH".
     * @return A {@link LocalDateTime} object corresponding to the input string.
     */
    public static LocalDateTime dateConvert(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    
    /**
     * Converts a single line of comma-separated flight data into a {@link Flight} object.
     * 
     * @param inputLine A comma-separated string representing flight data.
     * @return A {@link Flight} object created from the parsed data.
     */
    private static Flight lineToReport(String inputLine) {
        String[] items = inputLine.split(",");

        String originName = items[0];
        String originCity = items[1];
        String originState = items[2];

        Airport origin = new Airport(originName, originCity, originState);
        Airport destination = new Airport(items[3], items[4], items[5]);

        int passengers = Integer.parseInt(items[6]);
        int seats = Integer.parseInt(items[7]);
        int distance = Integer.parseInt(items[8]);
        LocalDateTime flightDate = dateConvert(items[9]);

        Flight flight = new Flight(origin, destination, flightDate, passengers, seats, distance);
        //System.out.println("Created Flight: " + flight); // Debug statement
        return flight;
    }

    /**
     * Reads flight data from a file and filters the flights based on the origin state.
     * Each valid flight entry is converted to a {@link Flight} object and stored in a {@link MyArrayList}.
     * 
     * @param filePath The file path to the data file containing flight records.
     * @param originStateFilter The state code used to filter flights based on the origin airport.
     * @return A {@link MyArrayList} of {@link Flight} objects that originate from the specified state.
     */
    public static MyArrayList<Flight> readDataFile(String filePath, String originStateFilter) {
        MyArrayList<Flight> flights = new MyArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the header

            while ((line = br.readLine()) != null) {
                Flight flight = lineToReport(line);
                if (flight.getOrigin().getState().equalsIgnoreCase(originStateFilter)) {
                    flights.add(flight);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        return flights;
    }
}
