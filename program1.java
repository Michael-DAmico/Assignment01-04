/**
 * @author Christian Burke and Michael D'Amico
 * @version 16 September 2024
 */
package flightpack;

/**
 * The {@code program1} class contains the main method to execute the flight data analysis tasks.
 * It reads flight data from a CSV file, performs various analyses, and outputs the results along with the time taken for each task.
 */
public class program1 {

	/**
     * The main method serves as the entry point for executing the program.
     * It reads the flight data from a file specified in the command-line arguments and performs several analysis tasks.
     * The results and the time taken for each task are printed to the console.
     * 
     * @param args an array of command-line arguments, where the first argument is expected to be the file path of the flight data CSV
     */
	public static void main(String[] args) {

		// Measure time to read the flight data file
		long fileReaderStart = System.currentTimeMillis();
        String filePath = args[0];
		Flight[] flights = MyDataReader.readDataFile(filePath);
		long fileReaderEnd = System.currentTimeMillis();
		System.out.println((fileReaderEnd - fileReaderStart) + " milliseconds to read the file");
		
		
		// Task 4.a: List of all airports in Maine
		long AirportsInMaineStart = System.currentTimeMillis();
		System.out.println("Name of all the airports in the state of Maine: " + MyAnalyzer.getAirportsInMaine(flights));
		long AirportsInMaineEnd = System.currentTimeMillis();
		System.out.println((AirportsInMaineEnd - AirportsInMaineStart) + " milliseconds for task 4.a");
		
		
		// Task 4.b: Maximum passengers to PWM
		long maxPassengerStart = System.currentTimeMillis();
		System.out.println("The maximum number of passengers coming to PWM with one flight:  " + MyAnalyzer.getMaxPassengersToPWM(flights));
		long maxPassengerEnd = System.currentTimeMillis();
		System.out.println((maxPassengerEnd - maxPassengerStart) + " milliseconds for task 4.b");
		
		
		// Task 4.c: Percentage of flights with no empty seats
		long PercentageOfFullFlightsStart = System.currentTimeMillis();
		System.out.println("The percentage of the flights with no empty seats:: " + MyAnalyzer.getPercentageOfFullFlights(flights));
		long PercentageOfFullFlightsEnd = System.currentTimeMillis();
		System.out.println((PercentageOfFullFlightsEnd - PercentageOfFullFlightsStart) + " milliseconds for task 4.c");
		
		
		// Task 4.d: Average passengers from PWM to FL in 2009
		long avgPassengerStart = System.currentTimeMillis();
		System.out.println("The average number of passengers on flights from PWM to FL in 2009: " + MyAnalyzer.getAveragePassengersFromAirportToStateInYear(flights, "PWM", "FL", 2009));
		long avgPassengerEnd = System.currentTimeMillis();
		System.out.println((avgPassengerEnd - avgPassengerStart) + " milliseconds for task 4.d");

    }

}
