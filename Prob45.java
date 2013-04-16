/*
Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:

Triangle	 	   Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
Pentagonal	 	Pn=n(3n1)/2	 	1, 5, 12, 22, 35, ...
Hexagonal	 	Hn=n(2n1)	 	1, 6, 15, 28, 45, ...
It can be verified that T285 = P165 = H143 = 40755.

Find the next triangle number that is also pentagonal and hexagonal.

Answer: 1533776805

Note: All hexagonal numbers are also triangle numbers! (no need to test triangle)

@author Westy92
*/

public class Prob45 extends Euler
{
   public static void main(String args[])
   {
      startTiming();

      long result = 0;
      for ( int i = 144; true; ++i )
      {
         long next = hexagonal(i);
         if ( isPentagonal(next) )
         {
            result = next;
            break;
         }
      }
      System.out.println(result);
      stopTiming();
   }
}