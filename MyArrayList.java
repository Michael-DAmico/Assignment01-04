package flightpack;

import java.util.Arrays;
import java.util.Comparator;

//public class MyArrayList {
	/**
	 * @author Michael
	 *
	 * @param <T>
	 */
	public class MyArrayList<T extends Comparable<T>>{
		private T[] elements; 
		private int size = 0;
		private static final int DEFAULT_CAPACITY = 10;
		public MyArrayList()
		{
			elements = (T[]) new Comparable [DEFAULT_CAPACITY];
			
		}
		
		public void add (T element) {
			if (size==elements.length)
				elements = ensureCapacity();
			elements[size] = element;
			size++;
		}
		
		public T[] ensureCapacity() {
			int capacity = elements.length;
			capacity*=2;
				return Arrays.copyOf(elements, capacity);
		}
		
		public T get (int index) {
			if(index<0 || index>=size)
				throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
			return elements[index];
			
		}
		
		
		public int size() {
			return size;
		}
		
		// from lecture
		public void sort() {
			for (int i = 1; i< this.size; i++)
				for (int j = i; j> 0 && (elements[j-1]).compareTo(elements[j]) > 0; j--) {
					T temp = elements[j];
					elements[j] = elements[j-1];
					elements[j-1]=temp;
				}
		}
		public String toString() {
			return Arrays.toString(elements);// this incase its in reverse order and changes it back to a string
		}
		public void sort(Comparator<? super T> comparator) {
			for (int i = 1; i< this.size; i++)
				for (int j = i; j> 0 && comparator.compare(elements[j-1], elements[j]).compareTo(elements[j]) > 0; j--) {
					T temp = elements[j];
					elements[j] = elements[j-1];
					elements[j-1]=temp;
				}
		}
	
		public static void main(String[]args) {
			
			MyArrayList<Integer> alist = new MyArrayList<Integer>();
			for(int i=1; i<=100; i++)
				alist.add("test");
			alist.sort();// testing the new method sort from lecture I changed the String to Integer to test it
			//System.out.println(alist.get(0));
			//System.out.println(alist.size);
			System.out.println(alist.toString());
		}
	

}
