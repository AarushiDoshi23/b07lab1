import java.io.*;
import java.util.Arrays;

public class Driver {
	public static void main(String [] args) 
	{
		double[] coeff1 = {13, 2};
		int[] pow1 = {0, 5};
		Polynomial poly1 = new Polynomial(coeff1, pow1);

		double[] coeff2 = {1, 0, 1, -1};
		int[] pow2 = {0, 1, 2, 3};
		Polynomial poly2 = new Polynomial(coeff2, pow2);

		double[] coeff3 = {1, 3, 5 ,7};
		int[] pow3 = {13, 3, 15, 7};
		Polynomial poly3 = new Polynomial(coeff3, pow3);

		double[] coeff4 = {1, 9, -11, -1, 5, -10};
		int[] pow4 = {2, 3, 6, 9, 7, 21};
		Polynomial poly4 = new Polynomial(coeff4, pow4);

		double[] coeff5 = {-5.6, -4.2};
		int[] pow5 = {0, 2};
		Polynomial poly5 = new Polynomial(coeff5, pow5);
		
		double[] coeff6 = {1, 2, 4, -9, 3};
		int[] pow6 = {3, 15, 13, 7, 0};
		Polynomial poly6 = new Polynomial(coeff6, pow6);

		double[] coeff7 = {1, 1};
		int[] pow7 = {3, 1};
		Polynomial poly7 = new Polynomial(coeff7, pow7);

		Polynomial poly8 = new Polynomial();

		System.out.println("---------------TESTS---------------");

		File p9 = new File("poly9.txt");

		try
		{
			Polynomial poly9 = new Polynomial(p9);
			System.out.println("Poly9");
			System.out.println("Expected: [15.0, 2.0, -9.8] and [2, 5, 7]");
			System.out.println("Received: " + Arrays.toString(poly9.coeff) + " and " + Arrays.toString(poly9.powers));
			System.out.println();

		}
		catch (IOException e) 
		{
            System.out.println(e.getMessage());
		}

		System.out.println("----------ADD----------");

		System.out.println("TEST 1: ADD POLY1 AND POLY1");
		Polynomial sum11 = poly1.add(poly1);
		System.out.println("Expected: [26.0, 4.0] and [0, 5]");
		System.out.println("Received: " + Arrays.toString(sum11.coeff) + " and " + Arrays.toString(sum11.powers));
		System.out.println();

		System.out.println("TEST 2: ADD POLY1 AND POLY2");
		Polynomial sum12 =  poly1.add(poly2);
		System.out.println("Expected: [14.0, 1.0, -1.0, 2.0] and [0, 2, 3, 5]");
		System.out.println("Received: " + Arrays.toString(sum12.coeff) + " and " + Arrays.toString(sum12.powers));
		System.out.println();

		System.out.println("TEST 3: ADD POLY2 AND POLY1");
		Polynomial sum21 =  poly2.add(poly1);
		System.out.println("Expected: [14.0, 1.0, -1.0, 2.0] and [0, 2, 3, 5]");
		System.out.println("Received: " + Arrays.toString(sum21.coeff) + " and " + Arrays.toString(sum21.powers));
		System.out.println();

		System.out.println("TEST 4: ADD POLY3 AND POLY6");
		Polynomial sum36 =  poly3.add(poly6);
		System.out.println("Expected: [3.0, 4.0, -2.0, 5.0, 7.0] and [0, 3, 7, 13, 15]");
		System.out.println("Received: " + Arrays.toString(sum36.coeff) + " and " + Arrays.toString(sum36.powers));
		System.out.println();

		System.out.println("TEST 5: ADD POLY1 AND POLY8");
		Polynomial sum18 =  poly1.add(poly8);
		System.out.println("Expected: [13.0, 2.0] and [0, 5]");
		System.out.println("Received: " + Arrays.toString(sum18.coeff) + " and " + Arrays.toString(sum18.powers));
		System.out.println();

		System.out.println("----------MULTIPLY----------");

		System.out.println("TEST 6: MULTIPLY POLY1 AND POLY2");
		Polynomial mult12 =  poly1.multiply(poly2);
		System.out.println("Expected: [13.0, 13.0, -13.0, 2.0, 2.0, -2.0] and [0, 2, 3, 5, 7, 8]");
		System.out.println("Received: " + Arrays.toString(mult12.coeff) + " and " + Arrays.toString(mult12.powers));
		System.out.println();

		System.out.println("TEST 7: MULTIPLY POLY2 AND POLY4");
		Polynomial mult24 = poly2.multiply(poly4);
		System.out.println("Expected: [1.0, 9.0, 1.0, 8.0, -20.0, 5.0, -11.0, 15.0, -5.0, -1.0, 1.0, -10.0, -10.0, 10.0] and [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 21, 23, 24]");
		System.out.println("Received: " +  Arrays.toString(mult24.coeff) + " and " + Arrays.toString(mult24.powers));
		System.out.println();

		System.out.println("TEST 8: MULTIPLY POLY2 AND POLY5");
		Polynomial mult25 = poly2.multiply(poly5);
		System.out.println("Expected: [-5.6, -9.8, 5.6, -4.2, 4.2] and [0, 2, 3, 4, 5]");
		System.out.println("Received: " +  Arrays.toString(mult25.coeff) + " and " + Arrays.toString(mult25.powers));
		System.out.println();
		
		System.out.println("TEST 9: MULTIPLY POLY5 AND POLY1");
		Polynomial mult51 = poly5.multiply(poly1);
		System.out.println("Expected: [-72.8, -54.6, -11.2, -8.4] and [0, 2, 5, 7]");
		System.out.println("Received: " +  Arrays.toString(mult51.coeff) + " and " + Arrays.toString(mult51.powers));
		System.out.println();

		System.out.println("TEST 10: MULTIPLY POLY2 AND POLY8");
		Polynomial mult28 = poly2.multiply(poly8);
		System.out.println("Expected: null and null");
		System.out.println("Received: " +  Arrays.toString(mult28.coeff) + " and " + Arrays.toString(mult28.powers));
		System.out.println();

		System.out.println("----------EVALUATE----------");

		System.out.println("TEST 11: EVALUATE POLY1 AT 2");
		System.out.println("Expected: 77.0");
		System.out.println("Received: " +  poly1.evaluate(2));
		System.out.println();

		System.out.println("TEST 12: EVALUATE POLY3 AT 2");
		System.out.println("Expected: 172952.0");
		System.out.println("Received: " +  poly3.evaluate(2));
		System.out.println();

		System.out.println("TEST 13: EVALUATE POLY5 AT 2.7");
		System.out.println("Expected: -36.218");
		System.out.println("Received: " +  poly5.evaluate(2.7));
		System.out.println();

		System.out.println("TEST 14: EVALUATE POLY2 AT 1.2");
		System.out.println("Expected: 0.7120000000000002");
		System.out.println("Received: " +  poly2.evaluate(1.2));
		System.out.println();

		System.out.println("TEST 15: EVALUATE POLY8 AT 1");
		System.out.println("Expected: 0.0");
		System.out.println("Received: " +  poly8.evaluate(1));
		System.out.println();

		System.out.println("----------HAS ROOT----------");

		System.out.println("TEST 16: HAS ROOT POLY1 AT 1");
		System.out.println("Expected: false");
		System.out.println("Received: " +  poly1.hasRoot(1));
		System.out.println();

		System.out.println("TEST 17: HAS ROOT POLY5 AT -1");
		System.out.println("Expected: false");
		System.out.println("Received: " +  poly5.hasRoot(-1));
		System.out.println();

		System.out.println("TEST 18: HAS ROOT POLY7 AT 0");
		System.out.println("Expected: true");
		System.out.println("Received: " +  poly7.hasRoot(0));
		System.out.println();

		System.out.println("TEST 19: HAS ROOT POLY8 AT 4");
		System.out.println("Expected: false");
		System.out.println("Received: " +  poly8.hasRoot(4));
		System.out.println();

		System.out.println("----------READ FROM FILE----------");

		System.out.println("TEST 20: READ FROM test1.txt");
		File f1 = new File("test1.txt");
		try 
		{
			Polynomial p1 = new Polynomial(f1);
			System.out.println("Expected: [5.0, -3.0, 7.0, -10.0] and [0, 2, 8, 9]");
			System.out.println("Received: " +  Arrays.toString(p1.coeff) + " and " + Arrays.toString(p1.powers));
			System.out.println();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		System.out.println("TEST 21: READ FROM test2.txt");
		File f2 = new File("test2.txt");
		try 
		{
			Polynomial p2 = new Polynomial(f2);
			System.out.println("Expected: [-9.0, -3.0, 14.22, -13.5] and [0, 2, 5, 17]");
			System.out.println("Received: " +  Arrays.toString(p2.coeff) + " and " + Arrays.toString(p2.powers));
			System.out.println();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	
		System.out.println("----------SAVE TO FILE----------");

		System.out.println("TEST 22: SAVE TO FILE POLY2");
		try
		{
			poly2.saveToFile("output.txt");
			System.out.println("Successfully written to output.txt\n");
		}
		catch (Exception e) 
		{
			System.err.println("Error saving to the: " + e.getMessage());
		}


		System.out.println("Reading from output.txt");
		try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) 
		{
			String line = reader.readLine();
			while (line != null) 
			{
				System.out.println("Received: " + line);
				line = reader.readLine();
			}
		} 
		catch (IOException e) 
		{
			System.err.println("Error reading the file: " + e.getMessage());
		}
		System.out.println("Expected: 1.0+1.0x2-1.0x3");
	}
}