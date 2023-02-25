package student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

public class PassengerLists {
	
	private Passenger[] customers;
	private int size = 0;
	public PassengerLists(String filename) throws FileNotFoundException {
		
		FileInputStream doc = new FileInputStream(filename);
		Scanner scnr = new Scanner(doc);
		String line;
		String name;
		String seat;
		String Aclass;
		ArrayList<Passenger> currFlight = new ArrayList<Passenger>();
		

		while(scnr.hasNext()) {
			line = scnr.nextLine();
			String[] parts = line.split(" ", 4); //Splits the line into 3 sections by each space
			name = parts[0] + " " + parts[1];//Get the name
			seat = parts[2]; //Get the seat
			Aclass = parts[3];
			Passenger pass = new Passenger(name, seat, Aclass);
			size++;
			currFlight.add(pass);
		}
		scnr.close();
		
		customers = currFlight.toArray(new Passenger[currFlight.size()]);
		
	}
	public Passenger[] getAll() {
		return customers;
	}
	public int getSize() {
		return size;
	}
	

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scnr = new Scanner(new InputStreamReader(System.in));
		
		//Pass in Delta.txt as the first run arguement and United.txt as the second
		PassengerLists deltaFlight = new PassengerLists(args[0]);
		PassengerLists unitedFlight = new PassengerLists(args[1]);
		
		//Test output of the deltaFlight object
		for(int i = 0; i < deltaFlight.getSize(); i++) {
			System.out.println(deltaFlight.getAll()[i].getName());
		}
		
		System.out.println("Hello! Please type in one of the following options (Check-In, Book, Boarding)");
		String input = scnr.nextLine();
		Menu(input, scnr);
	}
	
	private static void Menu(String input, Scanner scnr) {
		if (input.compareToIgnoreCase("Check-In") == 0) {
			//check-in method
		}
		else if (input.compareToIgnoreCase("Book") == 0) {
			//book method
		}
		else if (input.compareToIgnoreCase("Boarding") == 0) {
			// boarding method
		}
		else {
			System.out.println("Invalid input. Please try again, type one of these three options (Check-In, Book, Boarding)");
			Menu(scnr.nextLine(), scnr);
		}
	}
	
	//Check-In Method
	public void CheckIn() {
		
		
	}
}
