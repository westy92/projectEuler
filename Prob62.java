
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
The cube, 41063625 (3453), can be permuted to produce two other cubes: 56623104 (3843) and 66430125 (4053). In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.

Find the smallest cube for which exactly five permutations of its digits are cube.

Answer: 127035954683

@author Westy92
*/

public class Prob62 extends Euler
{
   static Map<String, ArrayList<Long>> digitCounts = new HashMap<String, ArrayList<Long>>();
   public static void main(String args[])
   {
      startTiming();

      for ( long i = 1; i < 10000; ++i )
         if ( countDigits(i*i*i) == 5 )
            break;

      stopTiming();
   }

   private static int countDigits(long i)
   {
      byte[] c = new byte[10];
      long inI = i;
      while ( i > 0 )
      {
         c[(int)(i%10)]++;
         i /= 10;
      }
      StringBuilder sb = new StringBuilder();
      for ( byte b: c )
         sb.append(b);
      ArrayList<Long> put = new ArrayList<Long>();
      put.add(inI);
      put = digitCounts.put(sb.toString(), put);
      if ( put != null )
      {
         put.add(i);
         digitCounts.put(sb.toString(), put);
         if ( put.size() == 5 )
            System.out.println(put.get(0));
         return put.size();
      }
      return 1;
   }
}
