/*
Working from left-to-right if no digit is exceeded by the digit to its left it is called an increasing number; for example, 134468.

Similarly if no digit is exceeded by the digit to its right it is called a decreasing number; for example, 66420.

We shall call a positive integer that is neither increasing nor decreasing a "bouncy" number; for example, 155349.

As n increases, the proportion of bouncy numbers below n increases such that there are only 12951 numbers below one-million that are not bouncy and only 277032 non-bouncy numbers below 10^10.

How many numbers below a googol (10^100) are not bouncy?

Answer: 51161058134250

Note: Across an increasing number, you can only increase the digit 8 times 
      (since we don't have a leading 0).  Across a decreasing number you 
      can decrease up to 9 times. When you add a digit, you keep the rest.
      Writing out increasing numbers reveals the pattern (8 + n) choose 8
      for the number of increasing numbers of the same length.
      Summing these up using the "rising sum of binom. coeff." yields:
      [(8 + digits + 1) choose (digits)] - 1.
      Decreasing numbers yields: [(9 + digits + 1) choose (digits)] - 1.
      There is a "- 1" since the sum includes "(9 + 0) choose 9" = 1.
      We must also remove double counted numbers:
      0 1 2 3 4 5 6 7 8 9, 00 11 22 33 44 55 66 77 88 99, ... with 10n.

@author Westy92
*/

public class Prob113 extends Euler
{
   
   static long nonBouncyBelow(int pow10) { // 10 ^ pow10
      return binomial(pow10 + 10L, pow10) - 1
           + binomial(pow10 + 9L, pow10) - 1
           - pow10 * 10;
   }
   
   public static void main(String[] args)
   {
      startTiming();
      System.out.println(nonBouncyBelow(100));
      stopTiming();
   }
}