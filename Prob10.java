/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * Answer: 142913828922
 *
 * @author Westy92
 */

public class Prob10 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      int checkPrime = 2;
      long totalSum = 0;
      while (checkPrime < 2000000)
      {
         if (isPrime(checkPrime))
            totalSum += checkPrime;
         checkPrime++;
      }
      System.out.println(totalSum);
      stopTiming();
   }
}
