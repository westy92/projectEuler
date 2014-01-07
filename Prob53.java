/**
There are exactly ten ways of selecting three from five, 12345:

123, 124, 125, 134, 135, 145, 234, 235, 245, and 345

In combinatorics, we use the notation, 5C3 = 10.

In general,

nCr =
n!
r!(nr)!
,where r  n, n! = n(n1)...321, and 0! = 1.
It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.

How many, not necessarily distinct, values of  nCr, for 1  n  100, are greater than one-million?

Answer: 4075

Note:  Don't computer entire binomial.  Return true as soon as it reaches 1M.

 Interesting:
 nCr 0   1   2   3   4   5
 0   1
 1   1   1
 2   1   2   1
 3   1   3   3   1
 4   1   4   6   4   1
 5   1   5   10  10  5   1
   Pascal's Triangle!

So C(n,r) = C(n-1,r-1) + C(n-1,r).
C(5,3) = 10, and C(4,2) + C(4,3) = 4 + 6 = 10

@author Westy92
*/

public class Prob53 extends Euler
{

   public static void main(String args[])
   {
      startTiming();
      int count = 0;
      for ( int n = 23; n <= 100; ++n )
         for ( int r = 1; r <= n; ++r )
            if ( binomOver1M(n, r) )
               count++;
      System.out.println(count);
      stopTiming();
   }

   private static boolean binomOver1M(int n, int r) // "n choose r"
   {
      int t = 1;
      int m = n - r;
      if ( r < m )
         r = m;
      for ( int i = n, j = 1; i > r; i--, ++j )
      {
         t = t * i / j;
         if ( t > 1000000 )
            return true;
      }
      return false;
   }
}
