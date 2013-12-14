/**
The first known prime found to exceed one million digits was discovered in 
1999, and is a Mersenne prime of the form 2^6972593 − 1; it contains exactly 
2,098,960 digits. Subsequently other Mersenne primes, of the form (2^p)−1, 
have been found which contain more digits.

However, in 2004 there was found a massive non-Mersenne prime which contains 
2,357,207 digits: 28433×2^7830457 + 1.

Find the last ten digits of this prime number.

Answer: 8739992577

Note: When doubling a number, its ones digit repeats itself every 4 times.
      The tens digit repeats itself every 20 times.
      It turns out that the Nth digit repeats 4*(5^(N-1)) times.
      Therefore the 10th digit repeats after 4*(5^9) = 7812500 times.
      7830457 % 7812500 = 17957.
      So the problem is simplified to 28433×2^17957 + 1

@author Westy92
*/

public class Prob97 extends Euler {
   
   public static void main(String args[]) {
      startTiming();
      long ans = 28433;
      for ( int i = 0; i < 7830457 % 7812500; i++ )
         ans = (ans << 1) % 10000000000L;
      System.out.println(ans + 1);
      stopTiming();
   }

}