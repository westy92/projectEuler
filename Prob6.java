/**
 * The sum of the squares of the first ten natural numbers is,
 *    1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 *    (1 + 2 + ... + 10)^2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten
 *    natural numbers and the square of the sum is 3025  385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred
 *    natural numbers and the square of the sum.
 * 
 * Answer: 25164150
 *
 * @author Westy92
 */

public class Prob6 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      int sumSquares = 0;
      int squareSums = 0;
      for (int i = 1; i <= 100; i++)
      {
         sumSquares += i * i;
         squareSums += i;
      }
      squareSums *= squareSums;
      System.out.println(squareSums - sumSquares);
      stopTiming();
   }
}
