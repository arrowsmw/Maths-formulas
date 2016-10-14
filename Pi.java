package maths.formulas;

import java.util.Scanner;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.lang.Math;
import static java.math.BigDecimal.ROUND_HALF_UP;
import java.math.MathContext;


public class Pi {
    
    
    private static final BigDecimal TWO = BigDecimal.valueOf(2);
    
    private static BigInteger findFactorial(long number, BigInteger sum){
        //System.out.println("number is: " + number);
        if(number > 1){
            sum = sum.multiply(BigInteger.valueOf(number));
            number-=1;
            return findFactorial(number, sum);
        }
        else{
            //System.out.println("Sum is" + sum);
            return sum;
        }
    }
    
    private static BigDecimal findSum(long number, BigDecimal sum){
        MathContext mc = new MathContext(2250);
        if(number != -1){
            BigInteger factOne = BigInteger.valueOf(1);
            factOne = findFactorial(number*6, factOne);
            BigInteger factTwo = BigInteger.valueOf(1);
            factTwo = findFactorial(number*3, factTwo);
            BigInteger factThree = BigInteger.valueOf(1);
            factThree = findFactorial(number, factThree);
            BigInteger partOne = BigInteger.valueOf(13591409);
            BigInteger partTwo = BigInteger.valueOf(545140134*number);
            BigInteger partThree = BigInteger.valueOf(1);
            
            for(int i=0; i<3; i++)
                partThree = partThree.multiply(factThree);
            
            BigInteger partFour = BigInteger.valueOf(-640320);
            partFour = partFour.pow((int)number*3);
            partOne = partOne.add(partTwo);
            
            BigInteger topRow = BigInteger.valueOf(1);
            topRow = topRow.multiply(factOne);
            topRow = topRow.multiply(partOne);
            
            BigInteger bottomRow = BigInteger.valueOf(1);
            bottomRow = bottomRow.multiply(factTwo);
            bottomRow = bottomRow.multiply(partThree);
            bottomRow = bottomRow.multiply(partFour);
            
            BigDecimal tmpTop = new BigDecimal(topRow,mc);
            BigDecimal tmpBottom = new BigDecimal(bottomRow,mc);
            
            
            BigDecimal tmpSum = new BigDecimal("0",mc);
            tmpSum = tmpSum.add(tmpTop,mc);
            //System.out.println("tmpTop is: " + tmpTop);
            //System.out.println("tmpBottom is: " + tmpBottom);
                    
            tmpSum = tmpSum.divide(tmpBottom,mc);
           
            sum = sum.add(tmpSum);
            number-=1;
            
            
            
            return findSum(number, sum);
            
        }
        else{
            return sum;
        }
    }
    
   private static BigDecimal squareRoot(BigDecimal value, int scale){
       
       BigDecimal partOne = new BigDecimal("0");
       BigDecimal partTwo = new BigDecimal(Math.sqrt(value.doubleValue()));
       
       while(!partOne.equals(partTwo)){
           partOne = partTwo;
           partTwo = value.divide(partOne, scale, ROUND_HALF_UP);
           partTwo = partTwo.add(partOne);
           partTwo = partTwo.divide(TWO, scale, ROUND_HALF_UP);
           
       }
       return partTwo;
       
       
   }
    
    public static void main(String[] args){
        
        Scanner numInput = new Scanner(System.in);
        
        //System.out.println("Enter the number of decimal places you want to calculate Pi to (NOT HIGHER THAN 2250): ");
        long input = 2250;//numInput.nextLong();
        int val = (int) input;
        MathContext mc = new MathContext(val);
        
        BigDecimal sum = new BigDecimal("0",mc);
        BigDecimal partOne = new BigDecimal("12",mc);
        BigDecimal partTwo = new BigDecimal("640320",mc);
        
        
        for(int i = 0; i<2; i++){
            partTwo = partTwo.multiply(BigDecimal.valueOf(640320),mc);
            //System.out.println("PartTwo is: " + partTwo);
        }
        partTwo = squareRoot(partTwo, (int) input);
        
        //System.out.println("Part two is: " + partTwo);
        BigDecimal partThree = new BigDecimal("0",mc);
        partThree = partThree.add(partOne);
        partThree = partThree.divide(partTwo,mc);
        //System.out.println("Part three is: " + partThree);
        sum = findSum(input/13, sum);
        //System.out.println("The sum is: " + sum);
        partThree = partThree.multiply(sum,mc);
        
        BigDecimal Pi = new BigDecimal("1",mc);
        
        Pi = Pi.divide(partThree, mc);
        
        System.out.println("The value of Pi to " + input + " decimal places is: " + Pi);
        
        
        
        
    }
    
    
}
