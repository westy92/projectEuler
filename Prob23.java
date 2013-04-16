/*
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.


Answer: 4179871

@author Westy92
*/
public class Prob23 extends Euler
{
   private static final int MAX = 20161;
   private static int [] abundants = new int[MAX];
   private static boolean [] sumOfTwoAbundants = new boolean[MAX*2+1];
   public static void main(String args[])
   {
      startTiming();
      // find abundants
      int count = 0;
      for ( int i = 1; i <= MAX; i++ )
         if ( isAbundant(i) )
            abundants[count++] = i;

      // find what can be written as sum of two abundants
      for ( int i = 0; i < count; ++i )
         for ( int j = 0; j <= i; ++j )
            sumOfTwoAbundants[abundants[i]+abundants[j]] = true;

      // sum up what isn't a sum of two abundants
      long sum = 0;
      for ( int i = 0; i <= MAX; i++ )
         if ( !sumOfTwoAbundants[i] )
            sum += i;

      System.out.println(sum);
      stopTiming();
   }
}
