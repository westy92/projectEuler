/*
Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.

If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:

1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

It can be seen that 2/5 is the fraction immediately to the left of 3/7.

By listing the set of reduced proper fractions for d ≤ 1,000,000 in ascending order of size, find the numerator of the fraction immediately to the left of 3/7.

Answer: 428570

Note: You can compare fractions by cross multiplying.
      2/5 vs. 3/7
      2*7 vs. 5*3
      14  vs. 15
      2/5  >  3/7
      We can also determine a new minimum denominator every time we find a
      new fraction.
      Given r/s < a/b, it's distance from the target is:
      a/b - r/s = (a*s - b*r)/(b*s) >= 1/(b*s)
      If the maximal fraction found so far is p/q, a necessary condition for
      r/s to be closer to the target is that:
      1/(b*s) < (a*q - b*p)/(b*q), or s > q/(a*q - b*p)

@author Westy92
*/

public class Prob71 extends Euler
{
   
   public static void main(String[] args)
   {
      startTiming();
      int a = 3, b = 7; // 3/7
      int bestNum = 0, bestDen = 1, minDen = 1;
      for (int den = 1000000; den > minDen; den--) {
         int num = (a*den)/b;
         if ((a*den) % b == 0 ) // multiple of a/b
            num--;
         if ( num * bestDen > den * bestNum ) {
            // Check if reduced?
            bestNum = num;
            bestDen = den;
            minDen = den / (a * den - b * num) + 1;
            System.out.println("New Best: " + bestNum + "/" + bestDen + " minDen: " + minDen);
         }
      }
      System.out.println(bestNum + " (denominator: " + bestDen + ")");
      stopTiming();
   }
}