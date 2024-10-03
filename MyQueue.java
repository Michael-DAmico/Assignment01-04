package flightpack;

import java.util.ArrayList;

public class MyQueue<T> {
	
	ArrayList<T> queue;
	
	public MyQueue() {
		queue = new ArrayList<T>();	
		
	}
		
	public boolean offer(T input) {
		return queue.add(input);
	}
	
	public T poll() {
		if(queue.size()==0)
			throw new NullPointerException();
		
		T item = queue.remove(0);
		return item;
		
	}
	
	public boolean isEmpty() {
		
	}
	public int size() {
		
		
	}
	
	public T peek() {
		
	}
	

}
