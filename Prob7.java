/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 *    that the 6th prime is 13.
 *
 * What is the 10,001st prime number?
 *
 * Answer: 104743
 *
 * @author Westy92
 */

public class Prob7 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      int curPrime = 3;
      int primes = 1;
      while ( primes < 10001 )
      {
         if ( isPrime(curPrime) )
            primes++;
         curPrime += 2;
      }
      System.out.println(curPrime - 2);
      stopTiming();
   }
}
