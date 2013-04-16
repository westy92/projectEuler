
import java.io.BufferedReader;
import java.io.FileReader;

/*
The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?

Answer: 162

@author Westy92
*/

public class Prob42 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      int count = 0;
      try
      {
         BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Westy92\\Desktop\\Other\\Project Euler\\test\\Prob42.in"));
         String bigLine = in.readLine();
         bigLine = bigLine.replaceAll("\"", "");
         String[] lines = bigLine.split(",");
         for ( String line : lines )
            if ( isTriangular(wordValue(line)) )
               count++;
         System.out.println(count);
      } catch( Exception e ) { }
      stopTiming();
   }

   private static int wordValue(String s)
   {
      int val = 0;
      for ( int i = 0; i < s.length(); ++i )
         val += s.charAt(i) - 'A' + 1;
      return val;
   }
}
