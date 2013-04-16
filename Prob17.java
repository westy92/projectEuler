
import java.util.HashMap;
import java.util.Map;

/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.

Answer: 21124

@author Westy92
*/

public class Prob17 extends Euler
{
   static Map<Integer, String> map = new HashMap<Integer, String>();
   public static void main(String args[])
   {
      startTiming();
      map.put(0, "");
      map.put(1, "one");
      map.put(2, "two");
      map.put(3, "three");
      map.put(4, "four");
      map.put(5, "five");
      map.put(6, "six");
      map.put(7, "seven");
      map.put(8, "eight");
      map.put(9, "nine");
      map.put(10, "ten");
      map.put(11, "eleven");
      map.put(12, "twelve");
      map.put(13, "thirteen");
      map.put(14, "fourteen");
      map.put(15, "fifteen");
      map.put(16, "sixteen");
      map.put(17, "seventeen");
      map.put(18, "eighteen");
      map.put(19, "nineteen");
      map.put(20, "twenty");
      map.put(30, "thirty");
      map.put(40, "forty");
      map.put(50, "fifty");
      map.put(60, "sixty");
      map.put(70, "seventy");
      map.put(80, "eighty");
      map.put(90, "ninety");
      int total = 0;
      for ( int i = 1; i <= 1000; i++ )
         total += getNameLength(i);
      System.out.println(total);
      stopTiming();
   }

   static int getNameLength(int n)
   {
      String s = getName(n);
      System.out.println(s);
      return s.length();
   }
   static String getName(int n)
   {
      String name = "";
      if ( n <= 20 )
         return map.get(n);
      if ( n < 100 )
      {
         int extra = n % 10;
         return map.get(n-extra) + getName(extra);
      }
      if ( n < 1000 )
      {
         int ones = n % 10;
         int tens = n % 100;
         int hundreds = n % 1000;
         if ( tens == 0 )
            return map.get(hundreds/100) + "hundred";
         return map.get(hundreds/100) + "hundredand" + getName(tens);
      }
      return "onethousand";
   }
}
