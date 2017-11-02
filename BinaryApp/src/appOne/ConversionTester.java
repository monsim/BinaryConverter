package appOne;


/**
 * Binary android app conversions
 * September 28, 2017
 * @author monsi
 *
 */
public class ConversionTester {

	public static void main(String[] args) {
		Conversion tester = new Conversion();
		String binary = tester.convertDecimalToBinary(-4096);
		System.out.println("B: " + binary);
				
		double decimal = tester.binaryToDecimal(binary); 
		System.out.println(decimal);
	}
}
