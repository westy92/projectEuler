/**
 * A Pythagorean triplet is a set of three natural numbers, a b c, for which,
 *    a^2 + b^2 = c^2
 *    For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 * Answer: 31875000
 * 
 * @author Westy92
 */

public class Prob9 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      int a = 1;
      int b = 1;
      final int MAX = 1000;
      while (a < MAX)
      {
         b = 1;
         while (b < MAX)
         {
            int addProd = a*a + b*b;
            double c = Math.sqrt(addProd);
            if ( c * c == addProd)
            {
               if ((a+b+c) == 1000)
                  System.out.println(a + " " + b + " " + c + " Addition: " + (a + b + c) + " Product: " + (int)(a * b * c));
            }
            b++;
         }
         a++;
      }
      stopTiming();
   }
}
