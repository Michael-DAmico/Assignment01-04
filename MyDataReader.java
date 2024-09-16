package flightpack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyDataReader {

	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH");
	
	public static LocalDateTime dateConvert(String dateTimeString) {
		return LocalDateTime.parse(dateTimeString, formatter);
	}
	
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
	
	public static Flight[] readDataFile(String filePath) {
		
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

}
