/**
 * @author Christian Burke and Michael D'Amico
 * @version 23 September 2024
 */
package flightpack;

import java.util.Arrays;
import java.util.Comparator;


	/**
	 * A custom implementation of an ArrayList that stores elements of a generic type
	 * and provides methods to add elements, retrieve elements, and sort the list.
	 * This class implements insertion sort for sorting both with and without a comparator.
	 * 
	 * @param <T> The type of elements stored in this list. The type must implement the
	 * Comparable interface to support sorting.
	 */
	public class MyArrayList<T extends Comparable<T>>{
		private T[] elements; 
		private int size = 0;
		private static final int DEFAULT_CAPACITY = 10;
		
		/**
	     * Constructs an empty list with an initial capacity of 10.
	     */
		public MyArrayList(){
			elements = (T[]) new Comparable [DEFAULT_CAPACITY];
		}
		
		/**
	     * Adds an element to the list. The list will dynamically resize if the current capacity
	     * is exceeded.
	     * 
	     * @param element The element to be added to the list.
	     */
		public void add (T element) {
			if (size==elements.length)
				elements = ensureCapacity();
			elements[size] = element;
			size++;
		}
		
		/**
	     * Ensures that the list has enough capacity to store additional elements by doubling
	     * the size of the underlying array.
	     * 
	     * @return A new array with double the capacity, containing all the existing elements.
	     */
		public T[] ensureCapacity() {
			int capacity = elements.length;
			capacity*=2;
				return Arrays.copyOf(elements, capacity);
		}
		
		/**
	     * Retrieves the element at the specified index in the list.
	     * 
	     * @param index The index of the element to retrieve.
	     * @return The element at the specified index.
	     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size).
	     */
		public T get (int index) {
			if(index<0 || index>=size)
				throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
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
		
		/**
	     * Sorts the elements in the list in ascending order using insertion sort. The sorting
	     * is based on the natural ordering of the elements (as defined by the Comparable interface).
	     */
		public void sort() {
			for (int i = 1; i< this.size; i++)
				for (int j = i; j> 0 && (elements[j-1]).compareTo(elements[j]) > 0; j--) {
					T temp = elements[j];
					elements[j] = elements[j-1];
					elements[j-1]=temp;
				}
		}
		/**
	     * Returns a string representation of the list, including all the elements stored in it.
	     * 
	     * @return A string representation of the list.
	     */
		public String toString() {
			return Arrays.toString(elements);// this incase its in reverse order and changes it back to a string
		}
		
		/**
		 * comparator.compare(elements[j-1], elements[j]) compares elements[j-1] and elements[j].
		 * If the result of this comparison is greater than 0, it means elements[j-1] is larger, and the two elements need to be swapped.
		 * The compareTo method you were using is unnecessary here since you're already using a Comparator for comparison.
		 * @param comparator
		 */
		public void sort(Comparator<? super T> comparator) {
			for (int i = 1; i< this.size; i++)
				for (int j = i; j > 0 && comparator.compare(elements[j-1], elements[j]) > 0; j--) {//.compareTo(elements[j]
					T temp = elements[j];
					elements[j] = elements[j-1];
					elements[j-1]=temp;
				}
		}
	} 
