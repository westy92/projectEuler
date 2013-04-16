/*
The number 3797 has an interesting property. Being prime itself,
it is possible to continuously remove digits from left to right, 
and remain prime at each stage: 3797, 797, 97, and 7.
Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

Answer: 748317

Note: Must start by 2,3,5 or 7 and end by 3 or 7 with 1, 3, 7 or 9 in between

@author Westy92
*/

public class Prob37 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      int sum = 0;
      for ( int i = 13; i <= 1000000; i += 2 )
      {
         if ( isTruncatablePrime(i) )
            sum += i;
      }
      System.out.println(sum);
      stopTiming();
   }

   private static boolean isTruncatablePrime(int n)
   {
      if ( (n % 10) != 3 && n % 10 != 7 )
         return false;
      int temp = n;
      while ( temp > 0 ) // 3797, 379, 37, and 3.
      {
         if ( !isPrime(temp) )
            return false;
         temp /= 10;
      }
      temp = n; // 3797, 797, 97, and 7.
      while ( temp >= 1 )
      {
         if ( !isPrime(temp) )
            return false;
         temp = leftTrunc(temp);
      }

      return true;
   }

   private static int leftTrunc(int n)
   {
      int l = 1;
      while  ( l * 10 < n )
         l *= 10;
      return n - n / l * l;
   }
}
