/**
Euler's Totient function, φ(n) [sometimes called the phi function], is used to
determine the number of numbers less than n which are relatively prime to n. 
For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively 
prime to nine, φ(9)=6.

n	Rel. Prime  φ(n)  n/φ(n)
2	1           1     2
3	1,2         2     1.5
4	1,3         2     2
5	1,2,3,4     4     1.25
6	1,5         2     3
7	1,2,3,4,5,6	6     1.1666...
8	1,3,5,7     4     2
9	1,2,4,5,7,8	6     1.5
10	1,3,7,9     4     2.5
It can be seen that n=6 produces a maximum n/φ(n) for n ≤ 10.

Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.

Answer: 510510

Note: The found values are the product of primes.
      2                   = 2
      2*3                 = 6
      2*3*5               = 30
      2*3*5*7             = 210
      2*3*5*7*11          = 2310
      2*3*5*7*11*13       = 30030
      2*3*5*7*11*13*17    = 510510  <- our answer
      2*3*5*7*11*13*17*19 = 9699690 <- out of our range
      These are known as Primorial numbers.

@author Westy92
*/

public class Prob69 extends Euler {
   
   public static void main(String args[]) {
      startTiming();
      double max = 1.0, temp;
      int maxN = 1;
      for ( int i = 2; i < 1000000; i++ ) {
         temp = (double)i / relativePrimes(i);
         if ( temp > max ) {
            max = temp;
            maxN = i;
            System.out.println("New max: " + maxN + " with n/φ(n)=" + max);
         }
      }
      System.out.println(maxN);
      stopTiming();
   }

}