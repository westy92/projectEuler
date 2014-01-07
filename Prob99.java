
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
Comparing two numbers written in index form like 211 and 37 is not difficult, as any calculator would confirm that 211 = 2048 < 37 = 2187.

However, confirming that 632382518061 > 519432525806 would be much more difficult, as both numbers contain over three million digits.

Using base_exp.txt (right click and 'Save Link/Target As...'), a 22K text file containing one thousand lines with a base/exponent pair on each line, determine which line number has the greatest numerical value.

NOTE: The first two lines in the file represent the numbers in the example given above.

Answer: 709

@author Westy92
*/

public class Prob99 extends Euler {

   public static void main(String args[]) {
      startTiming();
      double maxVal = 0;
      int maxLine = 0, currentLine = 1;
      try {
         BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Westy92\\Desktop\\Other\\Project Euler\\test\\Prob99.in"));
         String line = in.readLine();
         while ( null != line ) {
            Scanner sc = new Scanner(line);
            sc.useDelimiter(",");
            int base = sc.nextInt();
            int exp = sc.nextInt();
            double test = exp * Math.log(base);
            if ( test > maxVal ) {
               maxVal = test;
               maxLine = currentLine;
            }
            line = in.readLine();
            currentLine++;
         }
      } catch( Exception e ) { System.out.println(e);}
      
      
      System.out.println("Log of max is " + maxVal + " on line " + maxLine);
      stopTiming();
   }

}