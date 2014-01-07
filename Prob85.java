/*
By counting carefully it can be seen that a rectangular grid measuring 3 by 2 contains eighteen rectangles:

[image]

Although there exists no rectangular grid that contains exactly two million rectangles, find the area of the grid with the nearest solution.

Answer: 2772

Note: I derived the formula w(w+1)h(h+1)/4 = numRectangles(w,h)
      by calculating Nx1 rectangles by hand.
      1x1 = 1           = 1
      2x1 = 1 + 2       = 3
      3x1 = 1 + 2 + 3   = 6 ...
      Giving: w(w+1) = numRectangles(w)
      
      I realized that by plugging in width and height into that formula
      and multiplying the results yeilded the correct answer.
      3x2 = numRectangles(3) * numRectangles(2) = 6 * 3 = 18

@author Westy92
*/

public class Prob85 extends Euler
{
   static int numRectangles(int w, int h) {
      return (w*(w+1)*h*(h+1))/4;
   }
   
   static int diff(int x, int y) {
      if ( x > y )
         return x - y;
      return y - x;
   }
   
   public static void main(String[] args)
   {
      startTiming();
      int limit = 100;
      int width = 0, height = 0, rectangles = 1950000;
      
      for ( int w = 1; w < limit; w++ ) {
         for ( int h = 1; h < limit; h++ ) {
            if ( diff(numRectangles(w,h), 2000000) < diff(rectangles, 2000000) ) {
               rectangles = numRectangles(w,h);
               width = w;
               height = h;
               System.out.println(width + "x" + height + "=" + rectangles);
            }
         }
      }
      System.out.println(width*height);
      stopTiming();
   }
}
