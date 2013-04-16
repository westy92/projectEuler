/*
The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)

Answer: 872187

Note: only odd numbers can be a palindrome in base 2.

@author Westy92
*/

public class Prob36 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      int sum = 0;
      for ( int i = 1; i <= 1000000; i += 2 )
         if ( isPalindrome(i,10) && isPalindrome(i,2) )
            sum += i;
      System.out.println(sum);
      stopTiming();
   }
}
