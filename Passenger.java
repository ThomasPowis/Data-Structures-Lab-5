public class Passenger {
	private String name;
	private int seatNumber;
	private String className;
	
	public Passenger (String name, int seatNumber, String className) {
		this.name = name;
		this.seatNumber = seatNumber;
		this.className = className;
	}
	
	public String getName() {
		return name;
	}
	public int getseatNumber() {
		return seatNumber
	}
	public String getClass() {
		return className;
	}
	public String toString{
		return "Passenger Name: " + getName() + " Seat Number: " + getseatNumber() + " Class: " + getclassName();
	}
}
