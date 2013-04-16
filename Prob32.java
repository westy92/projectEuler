
import java.util.Set;
import java.util.TreeSet;


/*
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 * 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.

Answer: 45228

@author Westy92
*/

public class Prob32 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      Set<Integer> products = new TreeSet<Integer>();
      for ( int i = 1; i < 5000; i++ )
      {
         for ( int j = 1; j*i < 10000; j++ )
         {
            String s = i+""+j+""+i*j;
            if ( s.length() == 9 && isPandigital(s) )
               products.add(i*j);
         }
      }

      long sum = 0;
      for ( int i : products )
         sum += i;
      System.out.println(sum);
      stopTiming();
   }
}
