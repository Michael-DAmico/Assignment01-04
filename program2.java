/**
 * This class serves as the entry point for the flight sorting program.
 * It reads a data file of flights, sorts them both naturally and using a comparator,
 * and prints the time taken for each sorting operation.
 * 
 * @author Christian Burke and Michael D'Amico
 * @version 24 September 2024
 */
package flightpack;

public class program2 {

	/**
     * The main method of the program. It reads the flight data from the given file, sorts
     * the flights both naturally (by datetime) and using a custom comparator, and measures 
     * the time taken for each sorting operation.
     * 
     * @param args Command-line arguments. The first argument is the file path for the flight data.
     */
	public static void main(String[] args) {
		String filePath = args[0];
        String state = "ME";

        
		 // Read the data file into MyArrayList
        long startTime = System.nanoTime();
        MyArrayList<Flight> stateFlights = myDataReader.readDataFile(filePath, state);
        long endTime = System.nanoTime();
        //System.out.println(stateFlights.get(0));
        System.out.println(((endTime - startTime) / 1000000.0) + " ms to read the file");
        
     // Perform natural sorting (based on flight datetime)
        startTime = System.nanoTime();
        stateFlights.sort();
        endTime = System.nanoTime();
        System.out.println(((endTime - startTime) / 1000000.0) + " milliseconds to sort based on DateTime (6.a)");

        // Call sort again
        startTime = System.nanoTime();
        stateFlights.sort();
        endTime = System.nanoTime();
        System.out.println(((endTime - startTime) / 1000000.0) + " milliseconds to sort based on DateTime (6.b)");

        // Create a comparator for custom sorting
        FlightComparator comparator = new FlightComparator();

        // Perform custom sorting using the comparator
        startTime = System.nanoTime();
        stateFlights.sort(comparator); 
        endTime = System.nanoTime();
        System.out.println(((endTime - startTime) / 1000000.0) + " milliseconds to sort based on origin (7.a)");

        // Call sort again with the comparator
        startTime = System.nanoTime();
        stateFlights.sort(comparator);
        endTime = System.nanoTime();
        System.out.println(((endTime - startTime) / 1000000.0) + " milliseconds to sort based on origin (7.b)");

    }

  }

