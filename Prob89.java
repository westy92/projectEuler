
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/*
The rules for writing Roman numerals allow for many ways of writing each number (see About Roman Numerals...). However, there is always a "best" way of writing a particular number.

For example, the following represent all of the legitimate ways of writing the number sixteen:

IIIIIIIIIIIIIIII
VIIIIIIIIIII
VVIIIIII
XIIIIII
VVVI
XVI

The last example being considered the most efficient, as it uses the least number of numerals.

The 11K text file, roman.txt (right click and 'Save Link/Target As...'), contains one thousand numbers written in valid, but not necessarily minimal, Roman numerals; that is, they are arranged in descending units and obey the subtractive pair rule (see About Roman Numerals... for the definitive rules for this problem).

Find the number of characters saved by writing each of these in their minimal form.

Note: You can assume that all the Roman numerals in the file contain no more than four consecutive identical units.


Answer: 743

@author Westy92
*/

public class Prob89 extends Euler
{
   static Map<Character, Integer> map = new HashMap<Character, Integer>();
   public static void main(String args[])
   {
      startTiming();
      map.put('I', 1);
      map.put('V', 5);
      map.put('X', 10);
      map.put('L', 50);
      map.put('C', 100);
      map.put('D', 500);
      map.put('M', 1000);

      int total = 0;

      try
      {
         BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Westy92\\Desktop\\Other\\Project Euler\\test\\Prob89.in"));
         while ( in.ready() )
         {
            String line = in.readLine();
            total += line.length() - toRoman(fromRoman(line)).length();
         }
      } catch( Exception e ) { }
      System.out.println(total);
      stopTiming();
   }

   private static long fromRoman(String s)
   {
      long value = 0;
      for ( int i = 0; i < s.length(); i++ )
      {
         if ( i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i+1)) )
         {
            value += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
            i++;
         }
         else
            value += map.get(s.charAt(i));
      }
      return value;
   }

   private static String toRoman(long num)
   {
      String s = "";
      long temp = num;
      while ( temp > 0 )
      {
         if ( temp >= 1000 )
         {
            temp -= 1000;
            s += "M";
         }
         else if ( temp >= 900 )
         {
            temp -= 900;
            s += "CM";
         }
         else if ( temp >= 500 )
         {
            temp -= 500;
            s += "D";
         }
         else if ( temp >= 400 )
         {
            temp -= 400;
            s += "CD";
         }
         else if ( temp >= 100 )
         {
            temp -= 100;
            s += "C";
         }
         else if ( temp >= 90 )
         {
            temp -= 90;
            s += "XC";
         }
         else if ( temp >= 50 )
         {
            temp -= 50;
            s += "L";
         }
         else if ( temp >= 40 )
         {
            temp -= 40;
            s += "XL";
         }
         else if ( temp >= 10 )
         {
            temp -= 10;
            s += "X";
         }
         else if ( temp >= 9 )
         {
            temp -= 9;
            s += "IX";
         }
         else if ( temp >= 5 )
         {
            temp -= 5;
            s += "V";
         }
         else if ( temp >= 4 )
         {
            temp -= 4;
            s += "IV";
         }
         else if ( temp >= 1 )
         {
            temp--;
            s += "I";
         }
      }
      return s;
   }
}
