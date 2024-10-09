# Assignment01
Project Summary: Flight Data Analysis

This project is a flight data analysis tool developed in Java to process and analyze historical flight records for domestic flights in the U.S. between 1995 and 2009. The program reads flight data from a CSV file and provides various methods to extract insights and perform specific analyses.

The project consists of several key components:

Airport Class: This class represents an airport's details, including the airport's name, city, and state. It is used to store origin and destination airport data for each flight.

Flight Class: The Flight class holds details about individual flights, such as origin and destination airports, flight date, number of passengers, available seats, and flight distance.

MyAnalyzer Class: This class contains methods to perform specific analyses on the flight data:

Identify all unique airports in the state of Maine.
Determine the maximum number of passengers on a single flight arriving at Portland (PWM), Maine.
Calculate the percentage of flights that were fully booked.
Compute the average number of passengers on flights from Portland, Maine (PWM) to Florida in the year 2009.
MyDataReader Class: This class reads flight data from a CSV file and converts it into an array of Flight objects. It processes each line of the file and maps the data fields into corresponding Flight and Airport instances.

program1 Class: This class contains the main method that serves as the entry point for running the program. It reads the flight data file, runs the analysis methods from the MyAnalyzer class, and prints the results along with the time taken to perform each task.

Key Features:
File Reading: The project processes a large dataset (up to 3 million flight records) from a CSV file.
Efficient Analysis: The program performs various flight data analysis tasks, such as calculating maximum passengers, finding unique airports in a state, and more.
Performance Measurement: Each analysis task’s execution time is measured and displayed to ensure efficient processing of the dataset.
Use Case:
The project is useful for analyzing historical trends in domestic U.S. air travel, particularly focusing on airports in Maine and flights to and from Portland, Maine (PWM). It provides insights into flight capacity, passenger traffic, and the distribution of airports across different states.


# Assignment 2
Flight Sorting Program
Overview
This program processes flight data, allowing users to read, sort, and analyze flight records. The program utilizes a custom ArrayList implementation for storage and sorting.

Contributions:

Christian

  	MyArrayList<Flight> method,
  	90% of program 2,
  	Javadoc,
	  .PDF
  
  
Michael
	
 	FlightComparator class,
	MyArrayList,
	compareTo method in Flight class,
 	Javadoc,
	.Pdf


  
  Changes Made:
  
  	New class MyArrayList,
 	New class FlightComparator,
 	New method added in Flight class,
 	Modified method MyArrayList<Flight> readDataFile() in MyDataReader class,
	New class program2,
 	Updated Readme.
  


Classes
1. program2
Description: The entry point of the flight sorting program.
Purpose: Reads a data file of flights, sorts them both naturally (by datetime) and using a custom comparator, and measures the time taken for each sorting operation.
2. MyDataReader
Description: A utility class for reading flight data from a file.
Purpose: Provides methods to parse flight records and create Flight instances from the data. It filters flights based on the origin state.
3. MyArrayList
Description: A custom implementation of an ArrayList that supports generics.
Purpose: Manages a dynamic array of elements with methods to add, retrieve, and sort elements both naturally (using Comparable) and via a comparator.
4. MyAnalyzer
Description: A class for analyzing flight data.
Purpose: Contains methods to extract information such as unique airports in Maine, maximum passengers to a specific airport, percentage of full flights, and average passengers for specific routes and years.
5. FlightComparator
Description: A comparator class for sorting Flight objects.
Purpose: Implements Comparator<Flight> to allow sorting flights based on their origin airport names.
6. Flight
Description: Represents a flight record, including details such as the origin and destination airports, flight date, number of passengers, seats, and distance traveled.
Purpose: Provides getter and setter methods to access and modify flight information. Implements Comparable to allow sorting by flight date.
7. Airport
Description: Represents an airport with its associated name, city, and state.
Purpose: Provides methods to retrieve and modify airport details, used to represent the origin and destination airports in flight data.
Usage
To run the program, execute the program2 class, providing the path to the flight data file as a command-line argument, and input a State to sort by. The program will output the time taken to read the file and sort the flights using both natural order and the custom comparator.





# Assignment 3
Flight Data Analysis
Overview
This project processes and analyzes flight data from a CSV file, specifically filtering flights from the state of Maine (ME) and determining the total number of passengers departing from selected airports (PWM, BGR, AUG) between the years 1994 and 2009. The data is stored in a custom linked list data structure that allows for efficient insertion and retrieval based on flight date and origin airport.

Contributions:

Christian

  	add(Flight newFlight),
  	toString(),
   	90% of the Main program3
  	Javadoc,

  
  
Michael
	
 	class Node
  	15% add(Flight newFlight)
	insertSortedByDate(Node newNode),
	linkByOrigin(Node newNode),
 	Iterator<Flight> 
	.Pdf


  
  Changes Made:
  
  	New class MyLinkedList,
	New class program3,
 	Updated Readme.
  


Project Structure
MyLinkedList.java: A custom linked list implementation to store flights in sorted order by flight date. The list also allows for linking flights based on the origin airport.
Flight.java: Represents a flight, containing information such as flight date, origin airport, destination, and passenger count.
MyDataReader.java: A utility class to parse CSV data and convert it into Flight objects.
program3.java: The main program that reads flight data from a CSV file, stores it in the linked list, and provides analysis on the number of passengers from selected Maine airports during the given time period.
Features
Flight Insertion: Efficiently inserts flights into a linked list while maintaining sorted order by flight date.
Passenger Count Analysis: Calculates and prints the total number of passengers departing from selected airports in Maine (PWM, BGR, AUG) from 1994 to 2009.
Performance Timing: Measures and displays the time taken to read and process the flight data.

This will:

Read the flight data from the flights.csv file.
Filter and add flights that originate from Maine (ME) to the linked list.
Print the total number of passengers from airports PWM, BGR, and AUG between 1994 and 2009.

Performance Metrics
The program tracks the time taken to:

Read and process flight data from the CSV file.
Analyze passenger counts for the selected airports.

Key Classes and Methods


MyLinkedList:
add(Flight newFlight): Adds a new flight to the list in sorted order by date.
iterator(String airport, LocalDateTime start, LocalDateTime end): Returns an iterator for flights from a specific airport within a date range.


program3:


readFlights(String filePath, String state, MyLinkedList flightList): Reads flight data from a CSV file and adds flights to the list if the origin state matches the filter.
printPassengerCount(MyLinkedList flights, String airportName): Prints the total number of passengers for a given airport over the years 1994 to 2009.


# Assignment 4
Flight Data Analysis
Overview
This project simulates an airport security check queue system using a custom implementation of a generic queue data structure. It analyzes flight data from a CSV file, determines the number of counters required to process passengers efficiently, and outputs the results based on user input.

Contributions: We worked on everything together this just shows who took the lead on the tasks.

Christian
	
   	Method calculateMinimumCounters in QueueSimulator
    	Method addPassengers in QueueSimulator
     	Method processTheQueue QueueSimulator
	.Pdf
  	

  
  
Michael
	
 	Method flightSorted in MyDataReader,
  	Class MyQueue,
      	Method Simulation in QueueSimulator
	.Pdf


  
  Changes Made:
  
  	New class MyQueue,
	New class QueueSimulator,
 	New class program4,
  	Addition to class MyDataReader
 	Updated Readme.
  


Project Structure
1. MyQueue<T>
Description: A generic queue implementation using an ArrayList. It provides basic queue operations such as adding, removing, and inspecting elements.
Methods:
boolean offer(T input): Adds an element to the end of the queue.
T poll(): Removes and returns the element at the front of the queue.
boolean isEmpty(): Checks if the queue is empty.
int size(): Returns the current size of the queue.
T peek(): Returns the element at the front of the queue without removing it.
2. QueueSimulator
Description: This class simulates the processing of flight passengers through an airport security queue. It calculates the minimum number of counters required to handle passenger traffic efficiently based on given assumptions.
Methods:
boolean simulation(): Runs the simulation over the range of flight dates and processes the queue to determine if all passengers can be processed on time.
private void addPassengers(LocalDateTime ldt): Adds passengers to the queue based on flight departure times.
private boolean processQueue(): Processes the queue and determines if the current number of counters is sufficient.
public static int findMinimumCounters(ArrayList<Flight> sortedFlights): Finds the minimum number of counters required to process all passengers based on the provided flight data.
3. program4
Description: The main class that handles user input, reads flight data from a CSV file, and invokes the simulation process. It outputs the results, including the time taken for reading data and finding the minimum number of counters.
Usage:
bash
Copy code
java program4 <file path> <state> <airport name>
<file path>: The path to the CSV file containing flight data.
<state>: The state code used to filter flights based on the origin airport.
<airport name>: The name of the airport to filter and process flights.


