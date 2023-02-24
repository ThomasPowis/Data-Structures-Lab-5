package student;

//Class to create the passenger object
public class Passenger {
	private String name;
	private String seatNumber;
	private String className;
	
	public Passenger (String name, String seatNumber, String className) {
		this.name = name;
		this.seatNumber = seatNumber;
		this.className = className;
	}
	
	public String getName() {
		return name;
	}
	public String getseatNumber() {
		return seatNumber;
	}
	public String getClassName() {
		return className;
	}
	public String toString(){
		return "Passenger Name: " + getName() + " Seat Number: " + getseatNumber() + " Class: " + getClassName();
	}
}
