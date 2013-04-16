/*
A number chain is created by continuously adding the square of the digits in a number to form a new number until it has been seen before.

For example,

44  32  13  10  1  1
85  89  145  42  20  4  16  37  58  89

Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. What is most amazing is that EVERY starting number will eventually arrive at 1 or 89.

How many starting numbers below ten million will arrive at 89?

Answer: 8581146

@author Westy92
*/

public class Prob92 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      int count = 0;
      for ( int i = 1; i < 10000000; i++ )
         if ( hits89(i) )
            count++;
      System.out.println(count);
      stopTiming();
   }

   private static boolean hits89(int n)
   {
      while ( n != 1 && n != 89 )
         n = digitSquareSum(n);
      return n == 89;
   }


   private static int digitSquareSum(int n)
   {
      int sum = 0;
      while ( n > 0 )
      {
         int m = n % 10;
         n /= 10;
         sum += m*m;
      }
      return sum;
   }
}
