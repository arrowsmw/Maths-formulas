package maths.formulas;

import java.util.Scanner;
import java.math.BigInteger;

public class factorial {

    BigInteger sum = BigInteger.valueOf(0);

    private static BigInteger findFactorial(long number, BigInteger sum) {

        if (number > 1) {
            sum = sum.multiply(BigInteger.valueOf(number));
            number -= 1;
            return findFactorial(number, sum);
        } else {
            return sum;
        }

    }

    public static void main(String[] args) {

        Scanner numInput = new Scanner(System.in);

        System.out.println("Enter number to find the factorial of: ");
        long input = numInput.nextLong();

        BigInteger sum = BigInteger.valueOf(1);
        BigInteger factorial = findFactorial(input, sum);
        System.out.println("the result is: " + factorial + ".");

    }
}
