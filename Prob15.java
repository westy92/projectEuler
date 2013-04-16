/*
Starting in the top left corner of a 2x2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20x20 grid?


Answer: 137846528820

@author Westy92
My notes:
Notice how a Lattice Path on its side forms Pascal's triangle:
              1
 *         1     1          1st row
 *      1     2     1       2nd
 *   1     3     3     1    3rd
 *      4     6     4       4th
 *         10    10         5th
 *            20            6th
 *
 *
 * To find the number of Lattice Paths in an n*n box: "2n choose n"
*/

public class Prob15 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      System.out.println(binomial(20*2, 20));
      stopTiming();
   }
}
