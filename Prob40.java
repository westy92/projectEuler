/*
An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If d^n represents the nth digit of the fractional part, find the value of the following expression.

d^1  d^10  d^100  d^1000  d^10000  d^100000  d^1000000

Answer: 210

@author Westy92
*/

public class Prob40 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      String s = "0"+s(1000000); // account for index starting at 0
      int answer = 1;
      for ( int i = 1; i < 1000000; i *= 10 )
         answer *= s.charAt(i) - '0';
      System.out.println(answer);
      stopTiming();
   }

   private static String s(int len)
   {
      StringBuilder s = new StringBuilder();
      for ( int i = 1; s.length() < len; ++i )
         s.append(i);
      return s.toString();
   }

}
