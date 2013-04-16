/**
The following iterative sequence is defined for the set of positive integers:

n  n/2 (n is even)
n  3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13  40  20  10  5  16  8  4  2  1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.

Answer: 837799

@author Westy92
*/

public class Prob14 extends Euler
{

   public static void main(String args[])
   {
      startTiming();
      int maxNum = 0;
      long maxLen = 0;
      int currentNum = 1;
      while ( currentNum < 1000000 )
      {
         long len = collatzLength(currentNum);
         if ( len > maxLen )
         {
            maxLen = len;
            maxNum = currentNum;
         }
         currentNum++;
      }
      System.out.println(maxNum);
      stopTiming();
   }

   static long nextNum(long n)
   {
      if ( n % 2 == 0 )
         return n/2;
      return (3*n) + 1;
   }

   static long collatzLength(int n)
   {
      long temp = n;
      long length = 0;
      while ( temp != 1 )
      {
         temp = nextNum(temp);
         length++;
      }
      return length;
   }
}
