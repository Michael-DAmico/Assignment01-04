package flightpack;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Airport apl = new Airport("Delta", "York", "Maine");
		System.out.println(apl.getName()+", "+apl.getCity()+", "+apl.getState());
		System.out.println(args[0]);

		// Read the flight data from a file
		Flight[] flights = myDataReader.readDataFile(args[0]);

		// Get airports in Maine using MyAnalyzer
			Set<String> maineAirports = MyAnalyzer.getAirportsInMaine(flights);
       		 // Print all the airport names
			System.out.println("Airports in Maine:");
			for (String airport : maineAirports) {
				System.out.println(airport);
			}

		// Part B
    		int maxPassengersToPWM = MyAnalyzer.getMaxPassengersToPWM(flights);
    		System.out.println("The max passengers to PWM is, " + maxPassengersToPWM);
}
