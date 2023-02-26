package student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.zip.CheckedInputStream;

public class PassengerLists {

	private Passenger[] customers;
	public static Queue<Passenger> deltaCheckedIn = new LinkedList<>();
	public static Queue<Passenger> unitedCheckedIn = new LinkedList<>();
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
	//test comment
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scnr = new Scanner(new InputStreamReader(System.in));

		//Pass in Delta.txt as the first run arguement and United.txt as the second
		PassengerLists deltaFlight = new PassengerLists(args[0]);
		PassengerLists unitedFlight = new PassengerLists(args[1]);

		//Test output of the deltaFlight object
		for(int i = 0; i < deltaFlight.getSize(); i++) {
			System.out.println(deltaFlight.getAll()[i].getName());
		}

		Menu(deltaFlight, unitedFlight);
	}

	private static void Menu(PassengerLists first, PassengerLists second) {
		System.out.println("Hello! Please type in one of the following options (Check-In, Book, Boarding)");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		if (input.compareToIgnoreCase("Check-In") == 0) {
			//Check-In method
			//1. Pass in the name and the flight list
			//2. check if the name is in the flight list
			//3. If the name is in the array add it to some sort of data structure that stores the people that have checked in.
			System.out.println("What is you name");
			String Name = sc.nextLine();
			System.out.println("What flight are you on");
			String Flight = sc.nextLine();
			if(Flight.equalsIgnoreCase("Delta")) {
				CheckIn(first, Name, 0);
			}
			else {
				CheckIn(second, Name, 1);
			}
		}

		else if (input.compareToIgnoreCase("Book") == 0) {
			//book method
		}
		else if (input.compareToIgnoreCase("Boarding") == 0) {
			// boarding method
		}
		else {
			System.out.println("Invalid input. Please try again, type one of these three options (Check-In, Book, Boarding)");
		}
	}

	/*CheckIn method: is going to loop through the array of the passed in 
	 * airline calling the checkInSimulation method to see if a passenger
	 * does not check in
	 * then will work along with the NewPassengerSimulation to see if a new
	 * passenger needs to be added then will display the new passenger list
	 */
	public static void CheckIn(PassengerLists x, String Name, int airline) {//not finished
		for(int i = 0; i < x.getSize(); i++) {
			if(Name.equalsIgnoreCase(x.getAll()[i].getName())) {
				if(airline == 0) {//this is for delta Checkin
					System.out.println("delta works!");
					deltaCheckedIn.add(x.getAll()[i]);
					return;
				}
				else {//this is for united checking
					unitedCheckedIn.add(x.getAll()[i]);
					return;
				}
			}
		}
		System.out.println("You are not on the list, please book a flight");

	}
}
