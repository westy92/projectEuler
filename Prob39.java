/*
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p <= 1000, is the number of solutions maximised?

Answer: 840

Note: a + b > c
      a + b + c > 2c
      a + b + c <= 1000
      2c < a + b + c <= 1000
      c <= 500

@author Westy92
*/

public class Prob39 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      int answers[] = new int[1000];
      
      for ( int c = 1; c <= 500; ++c )
         for ( int b = 1; b < c; ++b )
            for ( int a = 1; a < b && a + b + c <= 1000; ++a )
               if ( a*a + b*b == c*c )
                  ++answers[a+b+c-1];

      // Check for largest value.
      int maxIndex = 0;
      for ( int i = 0; i < 1000; ++i )
         if ( answers[i] > answers[maxIndex] )
            maxIndex = i;

      System.out.println(maxIndex+1);
      stopTiming();
   }
}
