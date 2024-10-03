package flightpack;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class QueueSimulator {
	private ArrayList<Flight> aList; // Saves input data
	private MyQueue<Flight> queue; // used for simulation
	private int processTime; // the total process time in each day based on counters
	
	public QueueSimulator(ArrayList<Flight> alist, int numberCounter){    // minimum amount of counters needed
		this.aList = aList;
		queue = new MyQueue<Flight>();
		processTime = numberCounter * 60*60;
	}
	
	public boolean simulation() {
		LocalDateTime ldtStart = aList.get(0).getFlightDate();
		ldtStart = ldtStart.minusHours(1);
		LocalDateTime ldtEnd = aList.get(aList.size()-1).getFlightDate();
		for(LocalDateTime ldt = ldtStart; !ldt.isAfter(ldtEnd); ldt = ldt.plusHours(1)) {
			
			// add passenger to the queue of time ldt
			addPassengers(ldt);
			
			
			
			//process the queue
			boolean success = processQueue();
			if (success==false)
				return false;
			
		}
		return true;
	}

	private void addPassengers(LocalDateTime ldt) {
		while(this.aList.get(0).getFlightDate().equals(ldt.plusHours(1))) {
			
			queue.offer(aList.get(0));
			aList.remove(0);
		}
		
	}

	private boolean processQueue() {
		int currentProcessTime = processTime;
		while(currentProcessTime > 0 && !queue.isEmpty()) {
			
			Flight temp = queue.poll();
			currentProcessTime -= (6*temp.getPassengers());
		}
		if (currentProcessTime<0) {
			return false;
		}
	//	if(queue.isEmpty()) {
			return true;
	//	}
	//	return false;
	}
	
}
