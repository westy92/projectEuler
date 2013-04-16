import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


/*
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.

NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, as there are 299 altogether! If you could check one trillion (10^12) routes every second it would take over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)

Answer: 7273

@author Westy92
Notes: Take max sum of entry below and entry below and one to the right and add that to the current entry.
*/

public class Prob67 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      final int TREE_SIZE = 100;
      long[][] lines = new long[TREE_SIZE][TREE_SIZE];
      try
      {
         BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Westy92\\Desktop\\Other\\Project Euler\\test\\Prob67.in"));
         for ( int i = 0; i < TREE_SIZE; i++ )
         {
            String line = in.readLine();
            Scanner sc = new Scanner(line);
            for ( int j = 0; j < TREE_SIZE && sc.hasNext(); j++ )
               lines[i][j] = sc.nextInt();
         }
      } catch( Exception e ) { }
      for ( int i = TREE_SIZE - 1; i >= 0; i--)
      {
         for ( int j = 0; j < i; j++ )
            lines[i-1][j] = lines[i-1][j] + Math.max(lines[i][j], lines[i][j+1]);
      }
      System.out.println(lines[0][0]);
      stopTiming();
   }
}
