/**
 * @author Christian Burke and Michael D'Amico
 * @version 8 October 2024
 */
package flightpack;

import java.util.ArrayList;

public class MyQueue<T> {
	
    ArrayList<T> queue;

    public MyQueue() {
        queue = new ArrayList<>();
    }

    public boolean offer(T input) {
        return queue.add(input);
    }

    public T poll() {
        if (queue.isEmpty()) {
            throw new NullPointerException("Queue is empty");
        }
        return queue.remove(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public T peek() {
        if (isEmpty()) {
            throw new NullPointerException("Queue is empty");
        }
        return queue.get(0);
    }
}
