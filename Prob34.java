/*
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.

Answer: 40730

@author Westy92
*/

public class Prob34 extends Euler
{
   public static void main(String[] args)
   {
      startTiming();
      long sum = 0;
      for ( int i = 0; i < 50000; ++i )
         if ( isCuriousNumber(i) )
            sum += i;
      System.out.println(sum);
      stopTiming();
   }

   private static boolean isCuriousNumber(int n)
   {
      if ( n <= 2 )
         return false;
      int tempN = n;
      int sum = 0;
      while ( tempN != 0 ) // && sum <= n ?
      {
         sum += factorial(tempN % 10);
         tempN /= 10;
      }
      return n == sum;
   }
}
