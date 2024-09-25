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

  MyArrayList<Flight> method
  
  90% of program 2
  
  Javadoc
  
  .PDF
  
  
Michael
  FlightComparator class
  
  MyArrayList
  
  compareTo method in Flight class
  
  Javadoc
  
  .Pdf
  
  


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
