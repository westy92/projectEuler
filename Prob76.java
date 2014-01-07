/*
It is possible to write five as a sum in exactly six different ways:

4 + 1
3 + 2
3 + 1 + 1
2 + 2 + 1
2 + 1 + 1 + 1
1 + 1 + 1 + 1 + 1

How many different ways can one hundred be written as a sum of at least two positive integers?

Answer: 190569291

@author Westy92
*/

public class Prob76 extends Euler
{
   public static void main(String[] args)
   {
      startTiming();
      final int target = 100;

      // Dynamic programming
      int[] ways = new int[target + 1];
      ways[0] = 1; // "base case"

      for ( int i = 1; i < target; i++ )
         for ( int j = i; j <= target; j++ )
            ways[j] += ways[j - i];
      System.out.println(ways[target]);

      stopTiming();
   }
}
