package flightpack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class myDataReader {

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH");

    public static LocalDateTime dateConvert(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, formatter);
    }

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
