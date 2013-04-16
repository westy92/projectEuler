
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

Find the maximum total from top to bottom of the triangle below:

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)


Answer: 1074

@author Westy92
Notes: Take max sum of entry below and entry below and one to the right and add that to the current entry.
*/

public class Prob18 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      final int TREE_SIZE = 15;
      long[][] lines = new long[TREE_SIZE][TREE_SIZE];
      try
      {
         BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Westy92\\Desktop\\Other\\Project Euler\\test\\Prob18.in"));
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
