import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

/*
A common security method used for online banking is to ask the user for three random characters from a passcode. For example, if the passcode was 531278, they may ask for the 2nd, 3rd, and 5th characters; the expected reply would be: 317.

The text file, keylog.txt, contains fifty successful login attempts.

Given that the three characters are always asked for in order, analyse the file so as to determine the shortest possible secret passcode of unknown length.

Answer: 73162890

Note: I found the average position of each element, sorted that list, and then printed it in order!

@author Westy92
*/

public class Prob79 extends Euler
{
   private static int [] occurrences = new int[10];
   private static int [] positions = new int[10];
   private static double [] avgPositions = new double[10];
   public static void main(String args[])
   {
      startTiming();
      try
      {
         BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Westy92\\Desktop\\Other\\Project Euler\\test\\Prob79.in"));
         while ( in.ready() )
         {
            String line = in.readLine();
            for ( int i = 0; i < line.length(); i++ )
            {
               occurrences[line.charAt(i) - '0']++;
               positions[line.charAt(i) - '0'] += i + 1;
            }
         }

         // average positions
         for ( int i = 0; i < 10; i++ )
         {
            if ( occurrences[i] != 0 )
               avgPositions[i] = (double)positions[i]/occurrences[i];
         }

         Map<Double,Integer> sortedMap = new TreeMap<Double,Integer>();

         for ( int i = 0; i < 10; i++ )
            if ( avgPositions[i] > 0 )
               sortedMap.put(avgPositions[i], i);

         for(Map.Entry<Double,Integer> entry : sortedMap.entrySet())
         {
            System.out.print(entry.getValue());
         }
         System.out.println();

      } catch( Exception e ) { }
      stopTiming();
   }
}
