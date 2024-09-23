/**
 * @author Christian Burke and Michael D'Amico
 * @version 23 September 2024
 */

package flightpack;
import java.util.Comparator;

public class FlightComparator implements Comparator<Flight> {
    @Override
    public int compare(Flight f1, Flight f2) {
        return f1.getOrigin().getName().compareTo(f2.getOrigin().getName());
    }
}
