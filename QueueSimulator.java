package flightpack;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class QueueSimulator {
    private ArrayList<Flight> aList; // List of all flights
    private MyQueue<Flight> queue; // Queue for simulation
    private int processTime; // Total processing time based on counters

    public QueueSimulator(ArrayList<Flight> aList, int numberOfCounters) {
        this.aList = aList;
        this.queue = new MyQueue<>();
        this.processTime = numberOfCounters * 3600; // Processing time for all counters in seconds
    }

    public int calculateMinimumCounters() {
        LocalDateTime start = aList.get(0).getFlightDate();
        LocalDateTime end = aList.get(aList.size() - 1).getFlightDate();

        int totalCountersNeeded = 0;

        for (LocalDateTime date = start; !date.isAfter(end); date = date.plusDays(1)) {
            for (int hour = 0; hour <= 23; hour++) {
                LocalDateTime ldt = date.withHour(hour);
                addPassengers(ldt);
                if (!processTheQueue()) {
                    totalCountersNeeded = totalCountersNeeded + 1;
                }
            }
        }
        return totalCountersNeeded;
    }

    private void addPassengers(LocalDateTime ldt) {
        // Add all flights scheduled to depart at (h + 1) hour
        for (Flight flight : aList) {
            if (flight.getFlightDate().getHour() == ldt.getHour() + 1 && flight.getFlightDate().toLocalDate().equals(ldt.toLocalDate())) {
                queue.offer(flight);
            }
        }
    }

    private boolean processTheQueue() {
        int currentProcessTime = processTime;
        
        while (currentProcessTime > 0 && !queue.isEmpty()) {
            Flight flight = queue.poll();
            currentProcessTime -= (6 * flight.getPassengers()); // Each passenger takes 6 seconds
        }
        
        return currentProcessTime >= 0;
    }
}
