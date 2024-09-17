package flightpack;

import java.util.Arrays;

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
			if(index<0 || index>size)
				throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
			return elements[index];
			
		}
		
		
		public int size() {
			return size;
		}
		
		//public void sort()
		//public void sort(Comparator<? super T> comparator)
	
		public static void main(String[]args) {
			MyArrayList<String> alist = new MyArrayList<String>();
			alist.get(0);
			//System.out.println(false);
		}
	

}
