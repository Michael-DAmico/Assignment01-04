package flightpack;

import java.time.LocalDateTime;
import java.util.Iterator;

/**
 * A custom singly linked list class to store Flight objects.
 * Each node contains a reference to the next node and the next flight with the same origin airport.
 */
public class MyLinkedList {
    public static class Node {
        Flight data;       // Flight data
        Node next;        // Pointer to the next node
        Node nextAirport; // Pointer to the next flight of the same origin airport

        /**
         * Constructor for Node.
         *
         * @param data Flight data
         * @param next Pointer to the next node
         * @param nextAirport Pointer to the next flight of the same origin airport
         */
        public Node(Flight data, Node next, Node nextAirport) {
            this.data = data;
            this.next = next;
            this.nextAirport = nextAirport;
        }
    }

    Node header; // Head of the linked list
    private int size;    // Size of the linked list

    /**
     * Constructor for MyLinkedList.
     */
    public MyLinkedList() {
        header = null;
        size = 0;
    }

    /**
     * Adds a flight to the linked list in sorted order based on flight date.
     *
     * @param newFlight The Flight object to be added.
     */
    public void add(Flight newFlight) {
        Node newNode = new Node(newFlight, null, null);
        
        // Debug statement to show the flight being added
        //System.out.println("Attempting to add flight: " + newFlight);

        // Special case for the head end
        if (header == null || header.data.getFlightDate().compareTo(newFlight.getFlightDate()) > 0) {
            newNode.next = header;
            header = newNode;
            //System.out.println("Added flight at the head: " + newFlight);
        } else {
            Node current = header;
            // Find the correct position to insert the new node
            while (current.next != null && current.next.data.getFlightDate().compareTo(newFlight.getFlightDate()) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            //System.out.println("Inserted flight after " + current.data + ": " + newFlight);
        }

     // Update the nextAirport pointer
        Node airportNode = header;
        boolean addedToNextAirport = false;

        while (airportNode != null) {
            String currentOrigin = airportNode.data.getOrigin().getName().trim();
            String newFlightOrigin = newFlight.getOrigin().getName().trim();

           // System.out.println("Comparing: " + currentOrigin + " with " + newFlightOrigin);

            if (currentOrigin.equalsIgnoreCase(newFlightOrigin)) {
                Node temp = airportNode;

                // Check if this is the first flight for this airport
                if (temp.nextAirport == null) {
                    temp.nextAirport = newNode; // If it's the first, directly link it
                    //System.out.println("Added first flight to nextAirport chain: " + newFlight);
                } else {
                    // If not the first, find the correct position
                    //System.out.println("Found existing flights for airport: " + currentOrigin);
                    if (temp.nextAirport != null && temp.nextAirport.data.getFlightDate().compareTo(newFlight.getFlightDate()) < 0) {
                       // System.out.println("Moving to nextAirport flight: " + temp.nextAirport.data);
                        temp = temp.nextAirport;
                    }
                    newNode.nextAirport = temp.nextAirport; // Link the new node
                    temp.nextAirport = newNode; // Insert the new node in the chain
                   // System.out.println("Added flight to nextAirport chain: " + newFlight);
                }
                addedToNextAirport = true;
                break; // Exit the loop after adding the flight
            }
            airportNode = airportNode.next;
        }

        // After the loop, check if addedToNextAirport is still false
        if (!addedToNextAirport) {
            System.out.println("No existing flights found for airport: " + newFlight.getOrigin().getName());
        }




        if (!addedToNextAirport) {
            System.out.println("No existing airport node found for: " + newFlight.getOrigin().getName());
        }


        // Final debug statement confirming the flight was added
        //System.out.println("Flight added: " + newFlight);
    }



    /**
     * Inserts a new node into the linked list while maintaining sorted order by flight date.
     *
     * @param newNode The new node to insert.
     */
    private void insertSortedByDate(Node newNode) {
        if (header == null || header.data.getFlightDate().compareTo(newNode.data.getFlightDate()) > 0) {
            newNode.next = header;
            header = newNode;
        } else {
            Node current = header;
            while (current.next != null && current.next.data.getFlightDate().compareTo(newNode.data.getFlightDate()) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    /**
     * Links nodes with the same origin airport.
     *
     * @param newNode The newly added node.
     */
    private void linkByOrigin(Node newNode) {
        Node airportNode = header;
        while (airportNode != null) {
            if (airportNode.data.getOrigin().getName().equals(newNode.data.getOrigin().getName())) {
                Node temp = airportNode;
                while (temp.nextAirport != null && temp.nextAirport.data.getFlightDate().compareTo(newNode.data.getFlightDate()) < 0) {
                    temp = temp.nextAirport;
                }
                newNode.nextAirport = temp.nextAirport;
                temp.nextAirport = newNode;
                break;
            }
            airportNode = airportNode.next;
        }
    }

    /**
     * Returns an iterator for the linked list based on the specified airport and date range.
     *
     * @param airport The origin airport name.
     * @param start   The start date for the flight range.
     * @param end     The end date for the flight range.
     * @return An iterator for flights matching the criteria.
     */
    public Iterator<Flight> iterator(String airport, LocalDateTime start, LocalDateTime end) {
        return new MyItr(airport, start, end);
    }

    private class MyItr implements Iterator<Flight> {
        private Node current;
        private String airport;
        private LocalDateTime start;
        private LocalDateTime end; // Declare 'end' as an instance variable

        public MyItr(String airport, LocalDateTime start, LocalDateTime end) {
            this.airport = airport;
            this.start = start;
            this.end = end; // Initialize the instance variable
            current = header;

            // Find the first flight with the specified airport
            while (current != null && !current.data.getOrigin().getName().equals(airport)) {
                current = current.next;
            }

            // Move to the first flight within the start date range
            while (current != null && current.data.getFlightDate().compareTo(start) < 0) {
                current = current.nextAirport;
            }
        }

        @Override
        public boolean hasNext() {
            // Check if current node is not null and flight date is before or equal to the end date
            return current != null && current.data.getFlightDate().compareTo(end) <= 0;
        }

        @Override
        public Flight next() {
            // If there's no next flight, throw an exception (standard practice)
            if (!hasNext()) {
                throw new IllegalStateException("No more flights in the list.");
            }
            Flight f = current.data;  // Get the current flight data
            current = current.nextAirport;  // Move to the next flight with the same airport
            return f;
        }
    }


    /**
     * Returns the string representation of the linked list.
     *
     * @return A string representation of the list.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = header;
        while (temp != null) {
            sb.append(temp.data.toString()).append("\n");
            temp = temp.next;
        }
        return sb.toString();
    }

    /**
     * Returns the size of the linked list.
     *
     * @return The size of the list.
     */
    public int getSize() {
        return size;
    }
}
