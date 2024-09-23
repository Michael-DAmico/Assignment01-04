/**
 * @author Christian Burke and Michael D'Amico

 * @version 23 September 2024
 */
package flightpack;

public class program2 {

	public static void main(String[] args) {
		String filePath = args[0];
        String state = args[1];

		 // Read the data file into MyArrayList
        long fileReadStart = System.currentTimeMillis();
        MyArrayList<Flight> flights = MyDataReader.readDataFile(filePath, state);
        long fileReadEnd = System.currentTimeMillis();
        System.out.println((fileReadEnd - fileReadStart) + " milliseconds to read the file");

  }

}
