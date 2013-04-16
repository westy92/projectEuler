/*
Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 14 + 64 + 34 + 44
8208 = 84 + 24 + 04 + 84
9474 = 94 + 44 + 74 + 44
As 1 = 14 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.

Answer: 443839

@author Westy92
*/

public class Prob30 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      int sum = 0;
      for ( int i = 2; i <= 354294; ++i ) // 6*9^5=354294
      {
         int temp = digitFifthSum(i);
         if ( temp == i )
            sum += temp;
      }

      System.out.println(sum);
      stopTiming();
   }

   private static int digitFifthSum(int n)
   {
      int sum = 0;
      while ( n != 0 )
      {
         int nMod10 = (int) n % 10;
         sum += nMod10 * nMod10 * nMod10 * nMod10 * nMod10;
         n /= 10;
      }
      return sum;
   }
}
