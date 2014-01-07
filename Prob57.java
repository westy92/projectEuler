
import java.math.BigInteger;

/**
It is possible to show that the square root of two can be expressed as an infinite continued fraction.

 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...

By expanding this for the first four iterations, we get:

1 + 1/2 = 3/2 = 1.5
1 + 1/(2 + 1/2) = 7/5 = 1.4
1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...

The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is the first example where the number of digits in the numerator exceeds the number of digits in the denominator.

In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?

Answer: 153

Note:  Numerator (n) & Denominator(d)
       n(i) = d(i) + d(i-i)
       d(i) = n(i-1) + d(i-1)

@author Westy92
*/

public class Prob57 extends Euler
{

   public static void main(String args[])
   {
      startTiming();
      int count = 0;
      BigInteger prevN = BigInteger.valueOf(3);
      BigInteger prevD = BigInteger.valueOf(2);
      for ( int i = 0; i < 1000; ++i )
      {
         BigInteger tempD = prevN.add(prevD);
         prevN = tempD.add(prevD);
         prevD = tempD;
         if ( prevN.toString().length() > prevD.toString().length() )
         {
            count++;
            //System.out.println((i+2)+": "+prevN+"/"+prevD);
         }
      }
      System.out.println(count);
      stopTiming();
   }
}
