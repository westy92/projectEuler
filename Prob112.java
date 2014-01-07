/*
Working from left-to-right if no digit is exceeded by the digit to its left it is called an increasing number; for example, 134468.

Similarly if no digit is exceeded by the digit to its right it is called a decreasing number; for example, 66420.

We shall call a positive integer that is neither increasing nor decreasing a "bouncy" number; for example, 155349.

Clearly there cannot be any bouncy numbers below one-hundred, but just over half of the numbers below one-thousand (525) are bouncy. In fact, the least number for which the proportion of bouncy numbers first reaches 50% is 538.

Surprisingly, bouncy numbers become more and more common and by the time we reach 21780 the proportion of bouncy numbers is equal to 90%.

Find the least number for which the proportion of bouncy numbers is exactly 99%.

Answer: 1587000

@author Westy92
*/

public class Prob112 extends Euler
{   
   static boolean isBouncy(int n) {
      boolean increasing = false, decreasing = false;
      int prev = n % 10;
      n /= 10;
      while ( n > 0 ) {
         if ( prev > n % 10 )
            increasing = true;
         else if ( prev < n % 10 )
            decreasing = true;
         prev = n % 10;
         n /= 10;
      }
      return increasing && decreasing;
   }
   
   public static void main(String[] args)
   {
      startTiming();
      int bouncy = 0; //21780 * 0.9
      int total = 1;
      while ( 100 * bouncy / total != 99 ) {
         if ( isBouncy(++total) ) {
            bouncy++;
            System.out.println(total);
         }
      }
      System.out.println(total);
      stopTiming();
   }
}