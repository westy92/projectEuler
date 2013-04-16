/**
It is easily proved that no equilateral triangle exists with integral length sides and integral area. However, the almost equilateral triangle 5-5-6 has an area of 12 square units.

We shall define an almost equilateral triangle to be a triangle for which two sides are equal and the third differs by no more than one unit.

Find the sum of the perimeters of all almost equilateral triangles with integral side lengths and area and whose perimeters do not exceed one billion (1,000,000,000).

Answer: 518408346

Note: Use Pell’s equation.
  x^2 - 3y^2 = 1
  x = (3a + 1)/2

@author Westy92
*/

public class Prob94 extends Euler
{

   public static void main(String args[])
   {
      startTiming();
      long answer = 16; //
      long perim = 1;
      int x1 = 2, y1 = 1;
      long x = x1;
      long y = y1;
      while ( perim <= 1000000000 )
      {
         if ( (x + 2)*y % 3 == 0 )
         {
            perim = 2*x - 2; // 3(2x - 1)/3 - 1
            if ( perim > 1000000000 )
               break;
            //System.out.println((perim/3)+1);
            answer += perim;
         }
         else if( (x - 2) * y % 3 == 0 )
         {
            perim = 2*x; // 3(2x + 1)/3 - 1
            if ( perim > 1000000000 )
               break;
            //System.out.println((perim-1)/3);
            answer += perim;
         }
         long nextX = x1*x + 3*y1*y;
         long nextY = x1*y + y1*x;
         x = nextX;
         y = nextY;
      }

      System.out.println(answer);
      stopTiming();
   }
}
