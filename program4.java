package flightpack;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class program4 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java program4 <file path> <state> <airport name>");
            return;
        }

        String filePath = args[0];
        String state = args[1];
        String airportName = args[2];

        long startTime, endTime;

        // Step 1: Read data from file
        startTime = System.currentTimeMillis();
        ArrayList<Flight> flightsFromState = MyDataReader.readDataFile(filePath, state);
        ArrayList<Flight> flightsFromAirport = MyDataReader.flightSorted(flightsFromState, airportName);
        endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " milliseconds to read the flights from " + state + ", " + airportName);

        // Step 2: Sort flights and simulate counters
        QueueSimulator simulator = new QueueSimulator(flightsFromAirport, 10); // Example: start with 10 counters

        startTime = System.currentTimeMillis();
        int minimumCounters = simulator.calculateMinimumCounters();
        endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " milliseconds to find the minimum number of counters");
        System.out.println("Minimum number of counters: " + minimumCounters);
    }
}
