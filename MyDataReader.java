package flightpack;

import java.time.format.DateTimeFormatter;

public class MyDataReader {
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH");
	
	

	private static void Flight lineToReport(String_inputLine) {
		// TODO Auto-generated method stub
		String[]items = inputLine.split(',');
		String originName = items[0];
		String originCity = items[1];
		String originState = items[2];
		
		Airport origin = new Airport(originName,originCity, originState;
		Airport destination = new Airport (items[3],items[4], items[5]);
		int passenger= Integer.parseInt(items[6]);
		int seats= Interger.parseInt(items[7]);
		int distantce= Interger.parseInt(items[8]);
		LocalDateTime flightDate = dateConvert(items[9]);
		
		return new Flight(origin, destination, flightDate, seats, distance, passenger);
		
	}
public static Flight[] readDateFile(String filePath) {
	Flight[] data = new Flight [3000000];
	try (BufferedReader br = new BufferedReader(New FileReader(filepath))) {
		br.readline();
		String str;
		int currentIndex
	}
	catch (IOException e) {
		
	}
}
}
