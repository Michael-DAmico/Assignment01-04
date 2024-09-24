/**
 * @author Christian Burke and Michael D'Amico

 * @version 23 September 2024
 */
package flightpack;

public class program2 {

	public static void main(String[] args) {
		String filePath = args[0];
        String state = "ME";

        
		 // Read the data file into MyArrayList
        long startTime = System.nanoTime();
        MyArrayList<Flight> stateFlights = myDataReader.readDataFile(filePath, state);
        long endTime = System.nanoTime();
        //System.out.println(stateFlights.get(0));
        System.out.println((endTime - startTime) + " ns to read the file");
        
        startTime = System.nanoTime();
        stateFlights.sort(); // Natural sorting (based on flight datetime)
        endTime = System.nanoTime();
        System.out.println("Sort 6.a took: " + (endTime - startTime) + " ns");

        // Call sort again
        startTime = System.nanoTime();
        stateFlights.sort();
        endTime = System.nanoTime();
        System.out.println("Sort 6.b took: " + (endTime - startTime) + " ns");

        
        FlightComparator comparator = new FlightComparator();

        startTime = System.nanoTime();
        stateFlights.sort(comparator); // Custom sorting using the comparator
        endTime = System.nanoTime();
        System.out.println("Sort 7.a took: " + (endTime - startTime) + " ns");

        // Call sort again with the comparator
        startTime = System.nanoTime();
        stateFlights.sort(comparator);
        endTime = System.nanoTime();
        System.out.println("Sort 7.b took: " + (endTime - startTime) + " ns");

    }

  }

