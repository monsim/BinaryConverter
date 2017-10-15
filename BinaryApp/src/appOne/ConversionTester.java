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
		System.out.println(tester.convertDecimalToBinary(16));
		System.out.println(Integer.toBinaryString(16));
	}
}
