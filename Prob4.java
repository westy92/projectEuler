/**
 * A palindromic number reads the same both ways. The largest palindrome made
 *    from the product of two 2-digit numbers is 9009 = 91 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * Answer: 906609
 *
 * @author Westy92
 */

public class Prob4 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      int num = 0;
      for (int i = 999; i > 99; i--)
         for (int j = i - 1; j > 100; j--)
            if ( i*j > num && isPalindrome(i*j, 10) )
            {
               num = i*j;
               break;
            }

      System.out.println(num);
      stopTiming();
   }
}
