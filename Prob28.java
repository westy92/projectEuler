/*
Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?

Answer: 669171001

Note:
   Going down the diagonals:
       up, right:   4n^2 - 4n  + 1
       up, left:    4n^2 - 6n  + 3
       down, left:  4n^2 - 8n  + 5
       down, right: 4n^2 - 10n + 7
   Add these together:
                    16n^2 - 28n + 16 ( n > 1 )
   Formula for ring summation:
                    (1/3)*(16n^3 - 18n^2 + 14n - 9)

@author Westy92
*/

public class Prob28 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      int length = 1001; // length
      int n = (length + 1) / 2;
      long sum = (16*n*n*n - 18*n*n + 14*n - 9)/3;
      
      System.out.println(sum);
      stopTiming();
   }
}
