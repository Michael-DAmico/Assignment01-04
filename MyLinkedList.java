/**
 * @author Christian Burke and Michael D'Amico
 * @version 24 September 2024
 */
package flightpack;

import java.time.LocalDateTime;
import java.util.Iterator;

//import java.util.LinkedList;

public class MyLinkedList {
	
	private static class Node{
		Flight data;
		Node next;
		Node nextAirport;// always
		
		public Node(Flight data, Node next, Node nextAirport){
			this.data = data;
			this.next = next;
			this.nextAirport = nextAirport;
		}
	}
	
	private Node header;
	private int size;
	
	public MyLinkedList() {
		header = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public void add(Flight newFlight) {
		//TODO at home // focus on the first node then go to the second
	}
	
	public Iterator<Flight> iterator(String airport, LocalDateTime start, LocalDateTime end){ 
		return new MyItr(airport, start, end);
		
	}
	
	private class MyItr implements Iterator<Flight>{
		
		Node nextItem;
		
		public MyItr(String airport, LocalDateTime start, LocalDateTime end) {
			
			nextItem = header;// move this item forward until you hit the specified airport origin, and then it will search the origin flight within the range
			// start from header move to the next item till find first instance in linked list
			// with the same flight origin
			while(nextItem != null && !nextItem.data.getOrigin().getName().equals(airport))// pointer 1
				nextItem = nextItem.next;
			while(nextItem != null && nextItem.data.getFlightDate().compareTo(start)>=0)// pointer 2
				nextItem = nextItem.nextAirport;
		}

		@Override
		public boolean hasNext() {// scenerio 1 link has no next or date is out of range
			if (nextItem==null)
				return false;
			//check the date // TODO
			
			return true;
			//return nextItem != null;
		}

		@Override
		public Flight next() {
			if (nextItem== null)
				throw new IllegalStateException();
			// check the date // TODO
			
			Flight temp = nextItem.data;
			nextItem = nextItem.nextAirport;
			return temp;
		}
		
	}
	

}
