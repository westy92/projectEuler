/**
A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d  1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.


Answer: 983

Note: General idea - multiply by 10 and divide by test number until remainder of 1 is received.
      Factors of 2 and 5 don't have repeating digits in their remainders.
      The maximum recurring cycle length of 1/d is d-1. (So start high, work down!)

@author Westy92
*/

public class Prob26 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      
      int maxCount = 0;
      int max = 0;
      for ( int n = 999; n > 0; --n )
      {
         if ( n % 2 == 0 || n % 5 == 0 ) // Factors of 2 and 5 don't have repeating digits in their remainders.
            continue;
         if ( maxCount >= n ) // The maximum recurring cycle length of 1/d is d-1
            break;
         int count = 1;
         int i = 10 % n;
         while ( i != 0 && i != 1 )
         {
            i = (10 * i) % n;
            count++;
         }
         if ( count > maxCount )
         {
            maxCount = count;
            max = n;
         }
      }
      System.out.println(max);
      stopTiming();
   }


}
