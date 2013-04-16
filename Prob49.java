/**
The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?

Answer: 296962999629

@author Westy92
*/

public class Prob49 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      for ( int num = 1487; num < 3330; num += 2 )
         if ( isPrime(num) && isPrime(num+3330) && isPrime(num+6660) &&
              isPermutation(num, 3330+num) && isPermutation(num, num+6660) && isPermutation(num, num+6660) )
            System.out.println(num+""+(num+3330)+""+(num+6660));
      stopTiming();
   }
}
