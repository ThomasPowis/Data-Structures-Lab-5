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
	
//This is a test comment to try and fix an issue with github
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
	
	/*CheckIn method: is going to loop through the array of the passed in 
	 * airline calling the checkInSimulation method to see if a passenger
	 * does not check in
	 * then will work along with the NewPassengerSimulation to see if a new
	 * passenger needs to be added then will display the new passenger list
	 */
	public void CheckIn(ArrayList<Passenger> arr) {//not finished
		for (int i = 0; i < arr.size(); i++) {
			if(checkInSimulation(i, arr)) {
				
			}
		}
		}
	/*will call newPassengerSimulation method to see if a new passenger needs
	 * to be added
	 */
	public Passenger[] addPassenger(Passenger randomcustomer, Passenger[] airline){//not finished
		return  randomcustomer = airline.toArray(new Passenger[airline.length]);;

	//has a 5 percent chance of returning false when a passenger doesnt check in
		public static boolean checkInSimulation(int i, ArrayList<Passenger> arr) {
			Random rand = new Random();
			int sim = rand.nextInt(100);
			if(sim > 5) {
				return true;//returns true if the passenger checks in
			}
		arr.remove(i);
		return false;
		//returns false if the passenger doesn't check in and deletes them from the array
	}
		//has a 10 percent chance of returning false when a new passenger checks in

		public static boolean NewPassengerSimulation(PassengerLists arr, ArrayList<Passenger> randomcustomer) {
			Random rand = new Random();
			int sim = rand.nextInt(100);
			if(sim > 10) {
				return true;//returns true if no new passenger is checking in
			}
			arr.addPassenger(randomcustomer.get(0));
		return false;//returns false if a new passenger is checking in
	
		}

}
