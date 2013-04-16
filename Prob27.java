/*
Euler published the remarkable quadratic formula:

n² + n + 41

It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.

Using computers, the incredible formula  n²  79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to 79. The product of the coefficients, 79 and 1601, is 126479.

Considering quadratics of the form:

n² + an + b, where |a|  1000 and |b|  1000

where |n| is the modulus/absolute value of n
e.g. |11| = 11 and |-4| = 4
Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.

Answer: -59231

Note: a must be odd.

@author Westy92
*/

public class Prob27 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      int tempPrimes = 0;
      int numPrimes = 0;
      int a = 0;
      int b = 0;
      for ( int i = -999; i < 1000; i += 2 ) // must be odd
      {
         for ( int j = -999; j < 1000; ++j )
         {
            tempPrimes = getNumPrimes(i,j);
            if ( tempPrimes > numPrimes )
            {
               numPrimes = tempPrimes;
               a = i;
               b = j;
            }
         }
      }
      System.out.println("a: " + a);
      System.out.println("b: " + b);
      System.out.println("a*b: " + a*b);
      System.out.println("primes: " + numPrimes);
      stopTiming();
   }

   private static int getNumPrimes(int a, int b)
   {
      int num = 0;
      // seems to be true but slows it down a lot!
      //if ( !isPrime(a) || !isPrime(b) ) // works here, unknown if true.
         //return num;
      while ( isPrime( num * num + a * num + b ) )
         ++num;
      return num;
   }
}
