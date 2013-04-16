/*
It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 212
15 = 7 + 222
21 = 3 + 232
25 = 7 + 232
27 = 19 + 222
33 = 31 + 212

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?

Answer: 5777

@author Westy92
*/

public class Prob46 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      for ( int i = 3; i < 6000; i += 2 )
      {
         if ( !isPrime(i) )
         {
            if ( !primeAndTwiceSquare(i) )
            {
               System.out.println(i);
               break;
            }
         }
      }
      stopTiming();
   }

   private static boolean primeAndTwiceSquare(int in)
   {
      for ( int i = 2; i < in; i++ )
         if ( isPrime(i) )
            for ( int j = 1; j < in; j++ )
               if ( in == i + (2 * j * j) )
                  return true;
      return false;
   }
}
