package student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

public class PassengerLists<E> {
	
	private Passenger[] delta;
	private Passenger[] united;
	
	public PassengerLists(String filename) throws FileNotFoundException {
		/*
		 * This will be assuming that the lists will look like this
		 * "
		 * Delta:
		 * "name"; seat#, class
		 * "name"; seat#, class
		 * ...
		 * 
		 * United:
		 * "name"; seat#, class
		 * ...
		 */
		FileInputStream doc = new FileInputStream(filename);
		Scanner scnr = new Scanner(doc);
		String line;
		String name;
		String seat;
		String Aclass;
		int x;
		int y;
		ArrayList<Passenger> deltapass = new ArrayList<Passenger>();
		ArrayList<Passenger> unitedpass = new ArrayList<Passenger>();

		while(scnr.hasNext()) {
			line = scnr.nextLine();
			if (line.contains("Delta")){
				while(!line.contains("United") && scnr.hasNext()) {
					line = scnr.nextLine();
					x = line.indexOf(';');
					name = line.substring(0, x);
					y = line.indexOf(',');
					seat = line.substring(x +2, y);
					Aclass = line.substring(y+2);
					Passenger pass = new Passenger(name, seat, Aclass);
					deltapass.add(pass);
				}
			}
			if (line.contains("United")) {
				while(!line.contains("Delta") && scnr.hasNext()) {
					line = scnr.nextLine();
					x = line.indexOf(';');
					name = line.substring(0, x);
					y = line.indexOf(',');
					seat = line.substring(x +2, y);
					Aclass = line.substring(y+2);
					Passenger pass = new Passenger(name, seat, Aclass);
					unitedpass.add(pass);
				}
			}
		}
		scnr.close();
		
		delta = deltapass.toArray(new Passenger[deltapass.size()]);
		united = unitedpass.toArray(new Passenger[unitedpass.size()]);
		
	}
	public Passenger[] getAllDelta() {
		return delta;
	}
	public Passenger[] getAllUnited() {
		return united;
	}
	

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scnr = new Scanner(new InputStreamReader(System.in));
		
		PassengerLists pl = new PassengerLists(args[0]);
		
		System.out.println("Hello! Please type in one of the following options (Check-In, Book, Boarding)");
		String input = scnr.nextLine();
		Menu(input, scnr);
		
		//reading in passenger testing
		for(int i = 0; i<7; i++) {
			System.out.println(pl.getAllDelta()[i].getName() + ", Seat: #" + pl.getAllDelta()[i].getseatNumber() + ", " + pl.getAllDelta()[i].getClassName());
		}
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
	
	public void CheckIn() {
		
		
	}
}
