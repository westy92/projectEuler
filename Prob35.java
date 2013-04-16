/*
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?

Answer: 55

@author Westy92
*/

public class Prob35 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      int count = 0;
      for ( int i = 2; i < 1000000; i++ )
         if ( isCircularPrime(i) )
            count++;
      System.out.println(count);
      stopTiming();
   }
}
