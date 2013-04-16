/*
Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.

37 36 35 34 33 32 31
38 17 16 15 14 13 30
39 18  5  4  3 12 29
40 19  6  1  2 11 28
41 20  7  8  9 10 27
42 21 22 23 24 25 26
43 44 45 46 47 48 49

It is interesting to note that the odd squares lie along the bottom right diagonal, but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime; that is, a ratio of 8/13  62%.

If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed. If this process is continued, what is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%?

Answer: 26241

Note:
   Going down the diagonals:
       down, right: 4n^2 - 4n  + 1 <- never prime!
       down, left:  4n^2 - 6n  + 3
       up, left:    4n^2 - 8n  + 5
       up, right:   4n^2 - 10n + 7

@author Westy92
*/

public class Prob58 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      int prime = 3, total = 5;
      int i;
      for ( i = 3; prime / (double)total > .1; ++i )
      {
         //if ( isPrime(4*i*i - 4*i  + 1) ) // never prime
            //prime++;
         if ( isPrime(4*i*i - 6*i  + 3) )
            prime++;
         if ( isPrime(4*i*i - 8*i  + 5) )
            prime++;
         if ( isPrime(4*i*i - 10*i  + 7) )
            prime++;
         total += 4;
      }

      System.out.println((i-1)*2 - 1);
      stopTiming();
   }
}
