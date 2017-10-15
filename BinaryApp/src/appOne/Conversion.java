package appOne;

/**
 * Binary android app conversions
 * September 28, 2017
 * @author monsi
 *
 */
public class Conversion {
	
	
	/**
	 * decimal to binary
	 * @param number the decimal number to convert to 2's complement binary
	 * @return a String representation of the converted number to preserve the 0's
	 */
	public String convertDecimalToBinary(double number) {
		//use number to figure out the range for how many bits to use
		if (number == 0) {
			return "0000";
		}
		double numberOfBits = range(number);
		int signBit;
		String binary = "";
		if (number < 0) { //number is negative
			signBit = 1;
		} else {
			signBit = 0;
		}
		int result = -1;
		int remainder = -1;
		while (result != 0) {
			result = (int) Math.floor(number/2);
			remainder = (int)number % 2;
			binary = Integer.toString(remainder) + binary;
			number = result;
		}
		binary = signBit + binary;
		
		/*
		 * SIGNBIT = 0 or 1 depending on +/-
		 * this case 0
		 * 8/2 = 4 r 0
		 * 4/2 = 2 r 0
		 * 2/2 = 1 r 0
		 * 1/2 = 0 r 1
		 * = *SIGNBIT*1000
		 */
		return binary; 
	}
	
	/**
	 * calculates how many bits are needed
	 * @param number the decimal number to convert to 2's complement binary
	 * @return how many bits are needed to represent the number in 2's complement binary
	 */
	public double range(double number) {
//		System.out.println(number);
		double baseTen = Math.log10(number);
//		System.out.println(baseTen);
		double logTwo = Math.log10(2);
		double result = baseTen/logTwo; //change of base formula
//		System.out.println("result: " + result);
		if (result % 1 == 0) { //check if result is a whole number
//			System.out.println("hiIII");
			result++;
		} else {
//			System.out.println("hi");
			result = Math.round(result);
		}
		result++;
//		System.out.println(result);
		return result;
	}
}
