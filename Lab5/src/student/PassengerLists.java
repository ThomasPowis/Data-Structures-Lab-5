package student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.zip.CheckedInputStream;

//public class PassengerList created by Megan
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
	//Method to add a passenger to a PassengerList
	public void add(Passenger addPass) {
		customers = Arrays.copyOf(customers, customers.length+1);
		customers[customers.length-1] = addPass;
		size++;
	}
	
	//Main method made by Megan
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scnr = new Scanner(new InputStreamReader(System.in));

		//Pass in Delta.txt as the first run arguement and United.txt as the second
		PassengerLists deltaFlight = new PassengerLists(args[0]);
		PassengerLists unitedFlight = new PassengerLists(args[1]);

		
		Menu(deltaFlight, unitedFlight);
		
	}

	//Menu method made by Megan
	private static void Menu(PassengerLists first, PassengerLists second) {
		while(true) {
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
				System.out.println("Please type in the first letter of the airline you want to book a seat on: ");
				String air = sc.nextLine();
				System.out.println("Please enter your name: ");
				String name = sc.nextLine();
				System.out.println("Please enter your the first letter of your desired class (F for first , B for business and E for economy): ");
				String chosenClass = sc.nextLine();
				if(air.toUpperCase().equals("D")) {
					book(first,name,chosenClass,0);
				} else if(air.toUpperCase().equals("U")) {
					book(second,name,chosenClass,0);
				}
			}
			else if (input.compareToIgnoreCase("Boarding") == 0) {
				board();
				return;
			}
			else {
				System.out.println("Invalid input. Please try again, type one of these three options (Check-In, Book, Boarding)");
			}
		}
	}

	/*CheckIn method: is going to loop through the array of the passed in 
	 * airline calling the checkInSimulation method to see if a passenger
	 * does not check in
	 * then will work along with the NewPassengerSimulation to see if a new
	 * passenger needs to be added then will display the new passenger list
	 */
	//CheckIn method made by Jonathan Day
	public static void CheckIn(PassengerLists x, String Name, int airline) {//not finished
		for(int i = 0; i < x.getSize(); i++) {
			if(Name.equalsIgnoreCase(x.getAll()[i].getName())) {
				if(airline == 0) {//this is for delta Checkin
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
	
	//The book method made by Tom Powis
	public static void book(PassengerLists desiredFlight, String name, String desClass, int whichFlight) {
		//0 is delta 1 is united
		Scanner s = new Scanner(System.in);
		int fSize = 0; 
		int bSize = 0;
		int eSize = 0;
		for(int i = 0; i < desiredFlight.getSize(); i++) {
			String currClass = desiredFlight.getAll()[i].getClassName();
			if(currClass.equals("F")) {
				fSize++;
			}else if(currClass.equals("B")) {
				bSize++;
			}else if(currClass.equals("E")) {
				eSize++;
			}
		}
		
		while(true){
			desClass = desClass.toUpperCase();
			if(desClass.equals("F") && fSize < 10){
				break;
			}else if(desClass.equals("B") && bSize < 10) {
				break;
			}else if(desClass.equals("E") && eSize < 20) {
				break;
			}else if (eSize >= 20 && fSize >= 10 && bSize >= 10){
				//No seats left
				System.out.println("There are no seats left on this flight,  you are"
						+ "now on standby!");
				//noDelta.add()
				return;
			} else {
				//Choose different class
				System.out.println("This class is fully please select a different class: !");
				desClass = s.nextLine();
			}
		}
		
		int currSize = 0;
		//Getting current highest seat number 
		for(int i = 0; i < desiredFlight.getSize(); i++) {
			int currSeatNum = Integer.parseInt(desiredFlight.getAll()[i].getseatNumber());
			if(desiredFlight.getAll()[i].getClassName().equals(desClass) && currSeatNum > currSize) {
				currSize = currSeatNum;
			}
		}
		currSize = currSize+1;
		String seatNum = Integer.toString(currSize); 
		Passenger addPass = new Passenger(name,seatNum,desClass);
		desiredFlight.add(addPass);
		if(whichFlight==0) {
			deltaCheckedIn.add(addPass);
		}else {
			unitedCheckedIn.add(addPass);
		}
		//Seat is available
		System.out.println("You have been successfully added to this flight, your seat number is: " + currSize);
		return;
	}
	
	//Boarding method
	public static void board() {
		//Order:
		//First class
		//Business
		//Economy
		//Delta board first
		//Loop through the checkin queue for delta and pull out the passengers in the correct order 
		//Then print them
		//Then do the same for united
		Queue<Passenger> firstClass = new LinkedList<>();
		Queue<Passenger> businessClass= new LinkedList<>();
		Queue<Passenger> economy = new LinkedList<>();
		//Looping through and pulling out the passengers
		for(int i = 0; i < deltaCheckedIn.size(); i++) {
			if(deltaCheckedIn.peek().getClassName() == "F") {
				firstClass.add(deltaCheckedIn.poll());
			} else if(deltaCheckedIn.peek().getClassName() == "B") {
				businessClass.add(deltaCheckedIn.poll());
			} else {
				economy.add(deltaCheckedIn.poll());
			}
		}
		
		System.out.println("Delta boarding order:");
		for(int i = 0; i < firstClass.size(); i++) {
			System.out.println(firstClass.poll());
		}
		for(int i = 0; i < businessClass.size(); i++) {
			System.out.println(businessClass.poll());
		}
		for (int i = 0; i < economy.size(); i++) {
			System.out.println(economy.poll());
		}
		firstClass = null;
		businessClass = null;
		economy = null;
		for(int i = 0; i < unitedCheckedIn.size(); i++) {
			if(unitedCheckedIn.peek().getClassName() == "F") {
				firstClass.add(unitedCheckedIn.poll());
			} else if(unitedCheckedIn.peek().getClassName() == "B") {
				businessClass.add(unitedCheckedIn.poll());
			} else {
				economy.add(unitedCheckedIn.poll());
			}
		}
		
		System.out.println("United boarding order:");
		if(firstClass != null) {
			for(int i = 0; i < firstClass.size(); i++) {
				System.out.println(firstClass.poll());
			}
		}
		if(businessClass != null) {
			for(int i = 0; i < businessClass.size(); i++) {
				System.out.println(businessClass.poll());
			}
		}
		if(economy != null) {
			for (int i = 0; i < economy.size(); i++) {
				System.out.println(economy.poll());
			}
		}
		
		//Simulation method
		
	}
}
