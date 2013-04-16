
import java.math.BigInteger;

/*
n! means n * (n - 1) * ... * 3 * 2 * 1

For example, 10! = 10 * 9 * ... * 3 * 2 * 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!

Answer: 648

@author Westy92
*/

public class Prob20 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      BigInteger bigInt = factorial(BigInteger.valueOf(100));
      long digitSum = 0;
      String digits = bigInt.toString();
      for ( int i = 0; i < digits.length(); i++ )
         digitSum += digits.charAt(i) - '0';

      System.out.println(digitSum);
      stopTiming();
   }

   private static BigInteger factorial(BigInteger n)
   {
       BigInteger result = BigInteger.ONE;

       while (!n.equals(BigInteger.ZERO))
       {
           result = result.multiply(n);
           n = n.subtract(BigInteger.ONE);
       }

       return result;
   }
}
