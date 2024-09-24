package flightpack;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T extends Comparable<T>> {
    private T[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor
    @SuppressWarnings("unchecked")
	public MyArrayList() {
        elements = (T[]) new Comparable[DEFAULT_CAPACITY]; // Initial capacity
    }

    // Method to add elements to the array list
    public void add(T element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size] = element;
        size++;
    }

    // Ensure the capacity is doubled if needed
    private void ensureCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    // Method to get an element at a specific index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    // Return the current size of the array list
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

    // Sort using a Comparator (insertion sort with comparator)
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

    // Convert the array list to a string representation
    @Override
    public String toString() {
        T[] sortedArray = Arrays.copyOf(elements, size); // Avoid printing extra capacity slots
        return Arrays.toString(sortedArray);
    }

    // Main method for testing
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
}
