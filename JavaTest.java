import java.io.*; //Scanner
import java.util.*;
import java.math.*; //BigInteger

public class JavaTest {

	public static void main(String[] args) {
		//Avoid error message in console
	}

	public void sumBigIntegers() {

		Scanner in = new Scanner(System.in);
		System.out.print("Please input the number of integers:");
        int n = in.nextInt();
        BigInteger bigSum = new BigInteger("0");

		System.out.println("Please input the integers:");
        for (int i = 0; i < n; i++) {
			int num = 0;
			try {
            	num = in.nextInt();
			} catch(InputMismatchException ex) {
				System.out.println("Please input the integer in range -2^31 to 2^31-1");
				break;
			}
            BigInteger bigNum = new BigInteger(Integer.toString(num));
            bigSum = bigSum.add(bigNum);
        }

        System.out.println("Result: " + bigSum);
        in.close();
	}

}
