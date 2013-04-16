
import java.math.BigDecimal;

/*
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?


Answer: 1366

@author Westy92
My notes:
A double can fit 2^1000 perfectly BECAUSE it is a power of 2.
(11 bits for power.  -1022 < 1000 < 1023)
*/

public class Prob16 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      // A double can fit 2^1000 perfectly BECAUSE it is a power of 2.
      // (11 bits for power.  -1022 < 1000 < 1023)
      double number = Math.pow(2,1000);
      System.out.println(sumDigits(number));
      stopTiming();
   }

   static int sumDigits(double n)
   {
      int digitSum = 0;
      String s = new BigDecimal(n).toString();
      while ( s.length() > 0 )
      {
         digitSum += s.charAt(s.length() - 1) - '0';
         s = s.substring(0, s.length() - 1);
      }
      return digitSum;
   }
}
