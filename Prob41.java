/*
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?

Answer: 7652413

Note:  A number is divisible by 3 if the sum of its digits is divisible by 3.
       1+2+3+4+5+6+7+8+9=45 => always dividable by 3
       1+2+3+4+5+6+7+8=36 => always dividable by 3
       Must be 7 digits or less! 1234567 <= n <= 7654321.

@author Westy92
*/

public class Prob41 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      long max = 7654321;
      while ( !(isPandigital(max) && isPrime(max)) )
         max -= 2;
      System.out.println(max);
      stopTiming();
   }
}
