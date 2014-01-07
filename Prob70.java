/**
Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number of positive numbers less than or equal to n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, φ(9)=6.
The number 1 is considered to be relatively prime to every positive number, so φ(1)=1.

Interestingly, φ(87109)=79180, and it can be seen that 87109 is a permutation of 79180.

Find the value of n, 1 < n < 10^7, for which φ(n) is a permutation of n and the ratio n/φ(n) produces a minimum.

Answer: 8319823

@author Westy92
*/

public class Prob70 extends Euler {

   public static void main(String args[]) {
      startTiming();
      double min = 10.0;
      int minN = 0, relPrimes;
      for ( int i = 3; i < 10000000; i++ ) {
         relPrimes = relativePrimes(i);
         if ( isPermutation(relPrimes, i) && (double)i/relPrimes < min ) {
            min = (double)i/relPrimes;
            minN = i;
         }
      }
      System.out.println(minN);
      stopTiming();
   }

}