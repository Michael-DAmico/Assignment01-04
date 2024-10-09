/**
 * @author Christian Burke and Michael D'Amico
 * @version 23 September 2024
 */
package flightpack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A custom implementation of an ArrayList that stores elements of a generic type
 * and provides methods to add elements, retrieve elements, and sort the list.
 * This class implements insertion sort for sorting both with and without a comparator.
 * 
 * @param <T> The type of elements stored in this list. The type must implement the
 * Comparable interface to support sorting.
 */
public class MyArrayList<T extends Comparable<T>> implements Iterable<T> {
    private T[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

	/**
     * Constructs an empty list with an initial capacity of 10.
     */
    @SuppressWarnings("unchecked")
	public MyArrayList() {
        elements = (T[]) new Comparable[DEFAULT_CAPACITY]; // Initial capacity
    }

	/**
     * Adds an element to the list. The list will dynamically resize if the current capacity
     * is exceeded.
     * 
     * @param element The element to be added to the list.
     */    
    	public void add(T element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size] = element;
        size++;
    }
    	
    	/**
    	* Ensures that the list has enough capacity to store additional elements by doubling
	    * the size of the underlying array.
	    * 
	    * @return A new array with double the capacity, containing all the existing elements.
	    */    
    	private void ensureCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    	/**
	     * Retrieves the element at the specified index in the list.
	     * 
	     * @param index The index of the element to retrieve.
	     * @return The element at the specified index.
	     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size).
	     */
    	public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    	/**
	     * Returns the number of elements in the list.
	     * 
	     * @return The size of the list.
	     */
    	public int size() {
        return size;
    }

    // Natural sort using insertion sort (Comparable-based sorting)
    public void sort() {
        for (int i = 1; i < size; i++) {
            T current = elements[i];
            int j = i - 1;
            while (j >= 0 && elements[j].compareTo(current) > 0) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = current;
        }
    }

	/**
     * Sorts the elements in the list in ascending order using insertion sort. The sorting
     * is based on the natural ordering of the elements (as defined by the Comparable interface).
     */
    public void sort(Comparator<? super T> comparator) {
        for (int i = 1; i < size; i++) {
            T current = elements[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare(elements[j], current) > 0) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = current;
        }
    }

	/**
     * Returns a string representation of the list, including all the elements stored in it.
     * 
     * @return A string representation of the list.
     */
    @Override
    public String toString() {
        T[] sortedArray = Arrays.copyOf(elements, size); // Avoid printing extra capacity slots
        return Arrays.toString(sortedArray);
    }

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        // Adding elements
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(4);

        // Test natural sort
        System.out.println("Before sort: " + list);
        list.sort();  // Natural sorting using Comparable
        System.out.println("After natural sort: " + list);

        // Test sorting with a comparator (descending order)
        list.sort(Comparator.reverseOrder());
        System.out.println("After custom sort (descending): " + list);
    }

    
    /**
     * Iterator 
     * hasNext() and next()
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size; // Check if there are more elements
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in the array list.");
                }
                return elements[index++]; // Return the current element and move to the next
            }
        };
    }
}
