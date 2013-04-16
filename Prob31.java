/*
In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
It is possible to make £2 in the following way:

1£1 + 150p + 220p + 15p + 12p + 31p
How many different ways can £2 be made using any number of coins?

Answer: 73682

@author Westy92
*/

public class Prob31 extends Euler
{
   public static void main(String[] args)
   {
      startTiming();
      final int TOTAL = 200;

      
      // Dynamic programming
      int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
      int[] ways = new int[TOTAL + 1];
      ways[0] = 1; // "base case"

      for ( int coin: coins )
         for ( int j = coin; j <= TOTAL; j++ )
            ways[j] += ways[j - coin];
      System.out.println(ways[TOTAL]);

      stopTiming();
   }
}
