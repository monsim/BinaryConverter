package appOne;

/**
 * Binary android app conversions
 * September 28, 2017
 * @author monsi
 *
 */
public class Conversion {
	//variables to store the range
	private double lowerBound; 
	private double upperBound; 
	
	/**
	 * decimal to binary
	 * @param number the decimal number to convert to 2's complement binary
	 * @return a String representation of the converted number to preserve the 0's
	 */
	public String convertDecimalToBinary(double number) {
		//use number to figure out the range for how many bits to use
		if (number < 0) {
			return negativeConvert(number);
		} else if (number > 0) {
			return positiveConvert(number);
		}
		return "0000";
	}
	
	/**
	 * returns a string representation of the positive number in binary
	 * @param number a positive number
	 * @return the number in binary
	 */
	public String positiveConvert(double number) {
		String binary = "";
		double numberOfBits = range(Math.abs(number));
		int signBit;
		
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
	 * returns a string representation of the negative number in binary
	 * @param number a negative number
	 * @return the number in binary
	 */
	public String negativeConvert(double number) {
		int numBits = (int)range(number);
		double toConvert = Math.abs(lowerBound) - Math.abs(number);
		String converted = convertDecimalToBinary(toConvert);
		converted = "1" + converted;
		return converted;
	}
	
	/**
	 * calculates how many bits are needed
	 * @param number the decimal number to convert to 2's complement binary
	 * @return how many bits are needed to represent the number in 2's complement binary
	 */
	public double range(double number) {
		boolean isNegative = false; 
		if(number < 0) {
			isNegative = true; 
			//-1 to account for the fact that the positive part of the range is one less
			number = Math.abs(number);  
		}
		
		//we need log base 2 of the number to find the range
		//change of base: need base 10 of original number as well as base converting to
		double baseTen = Math.log10(number); 
		double logTwo = Math.log10(2);
		double result = baseTen / logTwo; //now the number is in base 2
		
		//check if the result is a whole number 
		if(result % 1 == 0) {
			//this means it is an exact power of two, and therefore is an edge case 
			//the upper bound typically doesn't allow the last power to be part of the range
			result ++; 
		}
		
		else {
			result = Math.round(result); 
		}
		
		result++; 
		
		if((isNegative) && (number % 8 == 0)) {
			result--; 
		}
		
		upperBound = Math.pow(2, result-1)-1;  
		lowerBound = upperBound+1; 
		
		System.out.println("-" + lowerBound + ", " + upperBound);
		return result; 
	}
	
	
	public double binaryToDecimal(String number) {
		if (number.substring(0,1).equals("1")) { //sigbit if 1. negative
			return negativeBinaryToDecimal(number);
		} else if (number.substring(0,1).equals("0")){ //sigbit is 0. positive
			return positiveBinaryToDecimal(number);
		} else {
			return 0;
		}
	}
	
	public double negativeBinaryToDecimal(String number) {
		double toReturn = 0;
		
	}
	
	
	public double positiveBinaryToDecimal(String number) {
		double toReturn = 0;
		int i = 0;
		while (!number.equals("")) {
			if (number.substring(number.length()-1, number.length()).equals("1")) {
				toReturn += Math.pow(2, i);
				number = number.substring(0, number.length()-1);
				i++;
			} else { //0
				number = number.substring(0, number.length()-1);
				i++;
			}
		}
		return toReturn;
		
	}
}
