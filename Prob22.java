import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;
/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938  53 = 49714.

What is the total of all the name scores in the file?

Answer: 871198282

@author Westy92
*/

public class Prob22 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      Map<String,Integer> sortedMap = new TreeMap<String,Integer>();
      try
      {
         BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Westy92\\Desktop\\Other\\Project Euler\\test\\Prob22.in"));
         String bigLine = in.readLine();
         bigLine = bigLine.replaceAll("\"", "");
         String[] lines = bigLine.split(",");
         for ( int i = 0; i < lines.length; i++ )
         {
            int letters = 0;
            for ( int j = 0; j < lines[i].length(); j++ )
               letters += (lines[i].charAt(j) - 'A' + 1);
            sortedMap.put(lines[i], letters);
         }
         long total = 0;
         Integer[] values = sortedMap.values().toArray(new Integer[sortedMap.size()]);
         for ( int i = 0; i < values.length; i++ )
         {
            total += (i+1)*values[i];
         }
         System.out.println(total);
      } catch( Exception e ) { }
      stopTiming();
   }
}
