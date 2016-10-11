package maths.formulas;

import java.util.Scanner;
import java.lang.StringBuilder;

public class Fibonacci {
    
    public static void main(String[] args){
        
        Scanner numInput = new Scanner(System.in);
        
        System.out.println("Enter number of digits to calculate the Fibonacci sequence to: ");
        int numDigits = numInput.nextInt();
        double firstSum = 0;
        double secondSum = 0;
        double tempSum = 0;
        StringBuilder stringBuilder = new StringBuilder();
        
        firstSum+=1;
        stringBuilder.append(firstSum);
        stringBuilder.append(", ");
        
        secondSum = firstSum;
        tempSum = secondSum;
        firstSum+=tempSum;
        stringBuilder.append(secondSum);
        stringBuilder.append(", ");
        
        for(int i = 1; i<(numDigits-2); i++){
            
            tempSum = secondSum;
            secondSum = firstSum;
            firstSum+=tempSum;
            stringBuilder.append(secondSum);
            stringBuilder.append(", ");
        }
        
        tempSum = secondSum;
        secondSum = firstSum;
        firstSum+=tempSum;
        stringBuilder.append(secondSum);
        stringBuilder.append(".");
        
        
        
        
        
        String finalstring = stringBuilder.toString();
        System.out.println("The Fibonacci sequence to " + numDigits + " digits is as follows: ");
        System.out.println(finalstring);
    }
}
