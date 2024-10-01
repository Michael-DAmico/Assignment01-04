package flightpack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

public class program3 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java program3 <flights.csv>");
            return;
        }

        System.out.println("Starting...");

        String filePath = args[0];
        String state = "ME";
        String[] airports = {"PWM", "BGR", "AUG"};

        MyLinkedList flightList = new MyLinkedList();

        long startTime = System.currentTimeMillis();
        readFlights(filePath, state, flightList);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " milliseconds to read the flights from " + state);

        for (String airport : airports) {
            printPassengerCount(flightList, airport);
        }
    }

    /**
     * Reads flights from the CSV file and adds them to the linked list if the origin state matches.
     *
     * @param filePath The path to the CSV file.
     * @param state The state code to filter flights.
     * @param flightList The linked list to store the flights.
     */
    public static void readFlights(String filePath, String originStateFilter, MyLinkedList flightList) {
        long startTime = System.currentTimeMillis(); // Start timer for performance measurement

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip the header

            String line;
            while ((line = br.readLine()) != null) { // Read lines until the end of the file
                Flight flight = myDataReader.lineToReport(line); // Convert line to Flight object

                // Check if the flight's origin state matches the filter
                if (flight.getOrigin().getState().equalsIgnoreCase(originStateFilter)) {
                    flightList.add(flight); // Add flight to linked list if it matches the state
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis(); // End timer
        System.out.println((endTime - startTime) + " milliseconds to read the flights from " + originStateFilter);
    }

    /**
     * Prints the total number of passengers from 1994 to 2009 for a specified airport.
     *
     * @param flights The MyLinkedList containing Flight objects to analyze.
     * @param airportName The name of the airport to filter the flights by.
     */
    public static void printPassengerCount(MyLinkedList flights, String airportName) {
        int[] passengerCounts = new int[16]; // For years 1994 to 2009 (inclusive)

        // Start from the head of the linked list
        MyLinkedList.Node current = flights.header; 
        while (current != null) {
            Flight flight = current.data; // Get the current flight
            // Check if the flight's origin matches the specified airport
            if (flight.getOrigin().getName().equalsIgnoreCase(airportName)) {
                LocalDateTime flightDate = flight.getFlightDate();
                int year = flightDate.getYear(); // Get the year of the flight

                // Check if the year is within range [1994, 2009]
                if (year >= 1994 && year <= 2009) {
                    int index = year - 1994; // Adjust index for array
                    passengerCounts[index] += flight.getPassengers(); // Sum passengers for the year
                }
            }

            current = current.next; // Move to the next node
        }

        // Print the results for the specified airport
        System.out.println("Printing the number of passengers from [1994, 2009] from " + airportName + ":");
        boolean hasData = false;
        for (int i = 0; i < passengerCounts.length; i++) {
            if (passengerCounts[i] > 0) {
                hasData = true;
            }
            System.out.println((1994 + i) + ", " + passengerCounts[i]);
        }
        if (!hasData) {
            System.out.println("No data found for " + airportName);
        }
    }
}
