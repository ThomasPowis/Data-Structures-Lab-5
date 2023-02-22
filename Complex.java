package Lab1;

public class Complex implements INumber<Complex>{
	//Creating the two variables that Complex accepts
	private double real;
	private double imaginary;
	
	//Creating the constructor for Complex
	public Complex(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	//Creating the real number getter
	public double getReal() {
		return real;
	}
	
	//Creating the imaginary number getter
	public double getImaginary() {
		return imaginary;
	}
	
	//Creating the toString method for the complex numbers
	public String toString() {
		//Formatting the output different if the imaginary number is positive or negative
		if(getImaginary()>0) {
			return(getReal() + " + " + getImaginary() + "i");
		}
		else {
			return(getReal() + " - " + (getImaginary() * -1) + "i");
		}
	}
	
	public static void main(String[] args) {
		Complex x = new Complex(3,2);
		Complex y = new Complex(1,7);
		System.out.println(x.multiply(y));
		
	}
	
	//Step 4
	//The order of this algorithm is O(n)
	//Checks if a complex number is in the array
	 public boolean complexCheck(INumber[] x, Complex y) {
		 for(int i = 0; i<x.length; i++) {
			 if(((Complex)x[i]).getReal() == y.getReal() && ((Complex)x[i]).getImaginary() == y.getImaginary()) {
				 return true;
			 }
		 }
		 return false;
	 }
	
	@Override
	//Creating the plus method
	public Complex plus(Complex input) {
		double newReal = this.getReal() + input.getReal(); //Creating the new real number by adding the two real numbers
		double newImag = this.getImaginary() + input.getImaginary(); //Creating the new imaginary numbers by adding the two imaginary numbers
		
		Complex newComp = new Complex(newReal, newImag); //Creating a new Complex number to output
		
		return newComp; //Returning the new added complex number
	}
	
	@Override
	//Creating the minus method
	public Complex minus(Complex input) {
		double newReal = this.getReal() - input.getReal(); //Creating the new real number by subtracting the two inputed real numbers
		double newImag = this.getImaginary() - input.getImaginary(); //Creating the new imaginary number by subtracting the two inputed imaginary numbers
		
		Complex newComp = new Complex(newReal, newImag); //Creating a new complex number to output
		
		return newComp; //Returning the new subtracted complex number
	}
	
	@Override
	//Creating the divide method
	public Complex divide(Complex input) {
		double newReal = ((this.getReal() * input.getReal()) + (this.getImaginary() * (input.getImaginary() * -1)* -1)) 
				/ ((input.getReal() * input.getReal()) + (input.getImaginary() * (input.getImaginary() * -1)*-1)); //Creating the new real number 
		
		
		double x = (this.getReal() * (input.getImaginary() *-1)) + (this.getImaginary() * input.getReal()); //Creating the numerator for the new imaginary number
		double y = (input.getReal() * input.getReal()) + (input.getImaginary() * (input.getImaginary() * -1)*-1); //Creating the new denominator for the new imaginary number
		double newImag = x/y; //Creating the new imaginary number
		
		Complex newComp = new Complex(newReal, newImag); //Creating the new complex number
		
		return newComp; //Returning the new complex number
	}
	
	//Creating the multiply method
	@Override
	public Complex multiply(Complex input) {
		double newReal = (this.getReal() * input.getReal()) + (this.getImaginary() * (input.getImaginary() * -1)); //Creating the new real number
		double newImag = (this.getReal() * input.getImaginary()) + this.getImaginary() * input.getReal(); //Creating the new imaganinary number
		
		Complex newComp = new Complex(newReal, newImag); //Creating the new complex number
		
		return newComp; //Returning the complex number
		
	}
	
	//Creating the print method
	@Override
	public void print() {
		System.out.println(this); //printing the inputed value
		
	}
	
}
