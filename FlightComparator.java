/**
 * @author Christian Burke and Michael D'Amico
 * @version 23 September 2024
 */

package flightpack;
import java.util.Comparator;

/**
 *FlightComparator is a comparator class used to compare two Flight objects.
 * It compares flights based on the origin airport name.
 * 
 * This class is designed to be used in conjunction with sorting algorithms 
 * where the order of flights based on their origin airport is required.
 */
public class FlightComparator implements Comparator<Flight> {
	
	 /**
     * Compares two Flight objects based on their origin airport name.
     * The comparison is case-insensitive and uses the String's compareTo method.
     * 
     * @param flight1 the first Flight object to be compared.
     * @param flight2 the second Flight object to be compared.
     * @return a negative integer, zero, or a positive integer if the name of the origin
     * airport of the first flight is lexicographically less than, equal to, 
     * or greater than the origin airport of the second flight.
     */
    @Override
    public int compare(Flight f1, Flight f2) {
        return f1.getOrigin().getName().compareTo(f2.getOrigin().getName());
    }
}
