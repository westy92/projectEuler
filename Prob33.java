/*
The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.

Answer: 100

@author Westy92
*/

public class Prob33 extends Euler
{
   public static void main(String[] args)
   {
      startTiming();
      int numerator = 1;
      int denominator = 1;
      for ( int i = 10; i < 100; ++i )
      {
         for ( int j = 10; j < i; ++j )
         {
            if ( isCuriousFraction(j,i) )
            {
               System.out.println("Found: "+j+"/"+i);
               numerator *= j;
               denominator *= i;
            }
         }
      }
      int gcd = gcd(numerator, denominator);
      System.out.println(denominator/gcd);
      stopTiming();
   }

   private static boolean isCuriousFraction(int numerator, int denominator)
   {
      if ( gcd(numerator, denominator) % 10 == 0 )
         return false;
      int num1 = numerator / 10;
      int num2 = numerator % 10;
      int denom1 = denominator / 10;
      int denom2 = denominator % 10;
      if ( num1 == denom1 )
         return numerator*denom2 == denominator*num2;
      else if ( num1 == denom2 )
         return numerator*denom1 == denominator*num2;
      else if ( num2 == denom1 )
         return numerator*denom2 == denominator*num1;
      else if ( num2 == denom2 )
         return numerator*denom1 == denominator*num1;
      return false;
   }
}
